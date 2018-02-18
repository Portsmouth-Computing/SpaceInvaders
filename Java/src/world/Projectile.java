
package world;

import main.Game;
import uni.Canvas;

/**
 * Represents a projectile in the world
 * @author mhops
 */
public class Projectile 
{
    public static final int HEIGHT = 20;
    public static final int WIDTH  = 3;
    private Vector2D position;
    private double ySpeed;
    private boolean shouldRemove;
    private boolean targetingPlayer;
    
    public Projectile(Vector2D position, double ySpeed)
    {
        this.position = position;
        this.ySpeed = ySpeed;
        this.shouldRemove = false;
        
        //If it moves down, target player, else target enemy
        targetingPlayer = ySpeed > 0;
    }
    
    public void update()
    {
        position.y += ySpeed;
        if (position.y > Game.HEIGHT || position.y < 0) {
            shouldRemove = true;
        }
    }
    
    public void draw(Canvas canvas)
    {
        canvas.fillRectangle(position.x, position.y, WIDTH, HEIGHT);
    }
    
    public boolean isTargettingPlayer()
    {
        return targetingPlayer;
    }
    
    public Boolean shouldBeRemoved()
    {
        return shouldRemove;
    }
    
    public Vector2D getPosition() 
    {
        return position;
    }
}
