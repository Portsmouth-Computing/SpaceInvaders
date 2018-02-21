package world;

import java.awt.Color;
import uni.Canvas;

/**
 *
 * @author mhops
 */
public class Player 
{  
    BoundingBox box;
    Vector2D velocity;
    
    public Player()
    {
        box = new BoundingBox(30, 30, 500, 675);
        velocity = new Vector2D();
    }
    
    public void move(Vector2D vector)
    {
        velocity.add(vector);
    }
    
    public void update()
    {
        box.movePosition(velocity.x, velocity.y);
        velocity.x *= 0.93;
    }
    
    public void draw(Canvas canvas) 
    {
        canvas.setForegroundColor(Color.GREEN);
        canvas.fillRectangle(box.getX(), box.getY(), 30, 30);
    }
    
    public Vector2D getPosition() 
    {
        return new Vector2D(box.getX(), box.getY());
    }
    
    public BoundingBox getBox()
    {
        return box;
    }
}
