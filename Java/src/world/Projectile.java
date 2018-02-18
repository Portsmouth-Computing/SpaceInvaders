
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
    private double ySpeed;
    private boolean shouldRemove;
    private boolean targetingPlayer;
    
    private BoundingBox box;
    
    public Projectile(Vector2D position, double ySpeed)
    {
        box = new BoundingBox(WIDTH, HEIGHT, position.x, position.y);
        this.ySpeed = ySpeed;
        this.shouldRemove = false;
        
        //If it moves down, target player, else target enemy
        targetingPlayer = ySpeed > 0;
    }
    
    public void update()
    {
        box.updatePosition(box.getX(), box.getY() + ySpeed);
        if (box.getY() > Game.HEIGHT || box.getY() < 0) {
            shouldRemove = true;
        }
    }
    
    public void draw(Canvas canvas)
    {
        canvas.fillRectangle(box.getX(), box.getY(), WIDTH, HEIGHT);
    }
    
    public boolean isTargettingPlayer()
    {
        return targetingPlayer;
    }
    
    public Boolean shouldBeRemoved()
    {
        return shouldRemove;
    }
    
    public BoundingBox getBox()
    {
        return box;
    }
}
