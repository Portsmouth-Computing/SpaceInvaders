package world;

import util.Vector2D;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import main.Game;
import uni.Canvas;
import renderer.Animation;
import renderer.AnimationType;

/**
 * Class to manage the invaders/ enemies of the game
 * @author mhops
 */
public class Invaders 
{
    /**
     * The direction the invaders are currently moving in
     */
    enum Direction 
    {
        LEFT,
        RIGHT
    }
    
    private final int ROWS = 5;
    private final int COLUMNS = 12;
    private final int MAX_INVADERS = ROWS * COLUMNS;
    
    private int aliveInvaders = MAX_INVADERS;
    private double leftPosition;
    private double rightPosition;
    private final double minLeft;
    private final double maxRight;
    
    private Direction invaderDirection;
    private ArrayList<Invader> invaders;
    private Random random;
    
    /**
     * Adds all the invaders into the game
     */
    public Invaders()
    {
        Animation[] animations = { 
            AnimationType.ENEMY_SHELL.get(),
            AnimationType.ENEMY_SQUID.get(), 
            AnimationType.ENEMY_SQUID.get(), 
            AnimationType.ENEMY_CLASSIC.get(), 
            AnimationType.ENEMY_CLASSIC.get()
        };
        random = new Random();
        leftPosition = 0;
        rightPosition = 0;
        minLeft = 65;
        maxRight = Game.WIDTH - minLeft;
        
        invaders = new ArrayList<>(50);
        leftPosition = Invader.WIDTH + Game.WIDTH / 4;
        for (int y = 0; y < ROWS; y++) {
            Animation animation = animations[y];
            for (int x = 0; x < COLUMNS; x++) {
                double xPos = x * Invader.WIDTH + x * 5 + Game.WIDTH / 4;
                double yPos = y * Invader.HEIGHT + y * 20 + Game.HEIGHT / 10;
                
                invaders.add(new Invader(animation, new Vector2D(xPos, yPos)));
             
                rightPosition = Math.max(rightPosition, (int)xPos);
            }
        }
    }
    
    /**
     * Moves all the invaders and maybe makes them shoot
     */
    public void move()
    {
        double speed = calculateSpeed();
        //Change bound positions
        leftPosition  += speed;
        rightPosition += speed;
        
        //If the invaders reach the edge of left/right of window
        //make them move the other way
        boolean moveDown = false;
        if (leftPosition <= minLeft) {
            invaderDirection = Direction.RIGHT;
            moveDown = true;
        }
        else if (rightPosition >= maxRight) {
            invaderDirection = Direction.LEFT;
            moveDown = true;
        }
        
        for (Invader invader : invaders) {
            invader.move(speed);
            if (moveDown) {
                invader.moveDown();
            }
        }  
    }
    
    /**
     * Tries to fire a projectile from a low-space invader. ~1/75 chance
     * @return The projectile fired
     */
    public Projectile tryShoot() 
    {
        if (random.nextInt(75) < 1) {
            Vector2D shootPoint = getRandomLowestInvaderPosition();
            return new Projectile(shootPoint, 3);
        }
        return null;
    }
    
    /**
     * Draws all the invaders
     * @param canvas The canvas to draw the invaders onto
     */
    public void draw(Canvas canvas)
    {
        canvas.setForegroundColor(Color.WHITE);
        for (Invader invader : invaders) {
            invader.draw(canvas);
        }
    }
    
    /**
     * Brute-force test for collision between a projectile and the invaders
     * @param projectile The projectile to test collisions against
     * @return Whether or not there was a collision
     */
    public HitResult invaderCollidesWithProjectile(Projectile projectile) 
    {
        for (Invader invader : invaders) {
            if (invader.getIsAlive()) {
                if (invader.getBox().isColliding(projectile.getBox())) {
                    invader.kill();
                    aliveInvaders--;
                    return new HitResult(true, invader.getPosition());
                }
            }
        }
        return HitResult.FAIL;
    }
    
    /**
     * Gets a random lowest point of an invader, used for firing projectiles from
     * this point.
     * @return A random point below an invader
     */
    private Vector2D getRandomLowestInvaderPosition() 
    {
        while (true) {
            int column = random.nextInt(COLUMNS - 1);
            for (int y = ROWS - 1; y > 0; y--) {
                Invader inv = invaders.get(y * COLUMNS + column);
                if (inv.getIsAlive()) {
                    Vector2D position = inv.getPosition().copy();
                    position.x += Invader.WIDTH / 2;
                    position.y += Invader.HEIGHT + 5;
                    return position;
                }
            }
        }
    }
    
    /**
     * Calculates the speed the invaders should move based on the number that
     * are still alive
     * @return Speed to move
     */
    private double calculateSpeed()
    {
        //Calculate the speed to move
        double speedFactor = (1.0 / aliveInvaders) * 10;
        double s = ((double)MAX_INVADERS / 7.5) * speedFactor;
        s = Math.min(Math.max(s, 1), 7.5) / 2.0;
        
        return invaderDirection == Direction.LEFT ? -s : s;
    }
}
