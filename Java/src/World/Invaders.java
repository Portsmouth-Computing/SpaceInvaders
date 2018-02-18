package world;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import main.Game;
import uni.Canvas;

/**
 *
 * @author mhops
 */
public class Invaders 
{
    enum Direction 
    {
        LEFT,
        RIGHT
    }
    
    private final int ROWS = 5;
    private final int COLUMNS = 11;
    
    private int leftPosition;
    private int rightPosition;
    private final int minLeft;
    private final int maxRight;
    
    private Direction invaderDirection;
    private ArrayList<Invader> invaders;
    private Random random;
    
    /**
     * Adds all the invaders into the game
     */
    public Invaders()
    {
        random = new Random();
        leftPosition = 0;
        rightPosition = 0;
        minLeft = 100;
        maxRight = Game.WIDTH - minLeft;
        
        invaders = new ArrayList<>(50);
        leftPosition = Invader.SIZE + Game.WIDTH / 4;
        for (int y = 0; y < ROWS; y++) {
            for (int x = 0; x < COLUMNS; x++) {
                double xPos = x * Invader.SIZE + x * 32 + Game.WIDTH / 4;
                double yPos = y * Invader.SIZE + y * 20 + Game.HEIGHT / 10;
                
                invaders.add(new Invader(new Vector2D(xPos, yPos)));
             
                rightPosition = Math.max(rightPosition, (int)xPos);
            }
        }
    }
    
    /**
     * Moves all the invaders and maybe makes them shoot
     */
    public void move()
    {
        double move = 1;
        double x = invaderDirection == Direction.LEFT ? -move : move;
        leftPosition += x;
        rightPosition += x;
        
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
            invader.move(x);
            if (moveDown) {
                invader.moveDown();
            }
        }  
    }
    
    public void tryShoot() 
    {
        if (random.nextInt(75) < 1) {
            Vector2D shootPoint = getRandomLowestInvaderPosition();
        }
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
        
        canvas.setForegroundColor(Color.RED);
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
                    position.x += Invader.SIZE / 2;
                    position.y += Invader.SIZE + 5;
                    return position;
                }
            }
        }
    }
}
