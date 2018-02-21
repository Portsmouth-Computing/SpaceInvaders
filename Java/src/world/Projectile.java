
package world;

import main.Game;
import uni.Canvas;

/**
 * Represents a projectile in the world
 * @author mhops
 */
public class Projectile 
{
    
    
    public static final int HEIGHT = 8;
    public static final int WIDTH  = 5;
    private double ySpeed;
    private boolean shouldRemove;
    private boolean targetingPlayer;
    
    private BoundingBox box;
    
    /**
     * Constructs the projectile
     * @param position Initial position of this projectile
     * @param ySpeed The speed of the projectile in the Y-Axis
     */
    public Projectile(Vector2D position, double ySpeed)
    {
        box = new BoundingBox(WIDTH, HEIGHT, position.x, position.y);
        this.ySpeed = ySpeed;
        this.shouldRemove = false;
        
        //If it moves down, target player, else target enemy
        targetingPlayer = ySpeed > 0;
    }
    
    /**
     * Updates the projectile by moving it, and testing collisions with 
     * screen edges.
     */
    public void update()
    {
        box.updatePosition(box.getX(), box.getY() + ySpeed);
        if (box.getY() > Game.HEIGHT || box.getY() < 0) {
            shouldRemove = true;
        }
    }
    
    /**
     * Draws the projectile
     * @param canvas The canvas to draw the projectile onto
     */
    public void draw(Canvas canvas)
    {
        canvas.fillRectangle(box.getX(), box.getY(), WIDTH, HEIGHT);
    }
    
    /**
     * Returns whether or not it is targeting the player
     * @return ^
     */
    public boolean isTargetingPlayer()
    {
        return targetingPlayer;
    }
    
    /**
     * Returns true if the projectile has reached screen edges
     * @return Whether or not the projectile should be removed
     */
    public Boolean shouldBeRemoved()
    {
        return shouldRemove;
    }
    
    /**
     * Gets bounding box of the projectile
     * @return box of the projectile
     */
    public BoundingBox getBox()
    {
        return box;
    }
}
