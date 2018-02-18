package world;

import uni.Canvas;

/**
 *
 * @author mhops
 */
public class Invader 
{
    public static final int SIZE = 32;
    public boolean isAlive = true;
    
    private Vector2D position;
    
    public Invader(Vector2D initialPosition)
    {
        position = initialPosition;
    }
    
    public void draw(Canvas canvas)
    {
        if (isAlive) {
            canvas.fillRectangle(position.x, position.y, SIZE, SIZE);
        }
    }
    
    public void move(double xOffset)
    {
        position.x += xOffset;
    }
    
    public void moveDown()
    {
        position.y += SIZE / 2;
    }
}
