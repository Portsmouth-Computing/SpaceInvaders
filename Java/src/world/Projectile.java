
package world;

import uni.Canvas;

/**
 * Represents a projectile in the world
 * @author mhops
 */
public class Projectile 
{
    public static final int HEIGHT = 20;
    public static final int WIDTH  = 3;
    Vector2D position;
    double ySpeed;
    
    public Projectile(Vector2D position, double ySpeed)
    {
        this.position = position;
        this.ySpeed = ySpeed;
    }
    
    public void update()
    {
        position.y += ySpeed;
    }
    
    public void draw(Canvas canvas)
    {
        canvas.fillRectangle(position.x, position.y, WIDTH, HEIGHT);
    }
}
