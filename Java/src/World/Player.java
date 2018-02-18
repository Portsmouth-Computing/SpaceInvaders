package world;

import java.awt.Color;
import uni.Canvas;

/**
 *
 * @author mhops
 */
public class Player 
{  
    Vector2D position;
    Vector2D velocity;
    
    public Player()
    {
        velocity = new Vector2D();
        position = new Vector2D(500.0, 650.0);
    }
    
    public void move(Vector2D vector)
    {
        velocity.add(vector);
    }
    
    public void update()
    {
        position.add(velocity);
        velocity.x *= 0.93;
    }
    
    public void draw(Canvas canvas) 
    {
        canvas.setForegroundColor(Color.GREEN);
        canvas.fillRectangle(position.x, position.y, 50, 50);
    }
}
