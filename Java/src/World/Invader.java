package world;

import uni.Canvas;

/**
 * Represents an invader/ enemy of the game
 * @author mhops
 */
public class Invader 
{
    public static final int SIZE = 22;
    public boolean isAlive = true;
    
    private Vector2D position;
    
    public Invader(Vector2D initialPosition)
    {
        position = initialPosition;
    }
    
    /**
     * Draws the invader
     * @param canvas The canvas to draw the invader onto
     */
    public void draw(Canvas canvas)
    {
        if (isAlive) {
            canvas.fillRectangle(position.x, position.y, SIZE, SIZE);
        }
    }
    
    /**
     * Moves the invaders X-Position by the given parameter
     * @param xOffset The amount to offset the invader by in X-Axis
     */
    public void move(double xOffset)
    {
        position.x += xOffset;
    }
    
    /**
     * Moves the invader down to the next row
     */
    public void moveDown()
    {
        position.y += SIZE / 2;
    }
    
    /**
     * Gets whether the invader is still alive
     * @return whether the invader is alive
     */
    public boolean getIsAlive() 
    {
        return isAlive;
    }
    
    /**
     * Gets the position of the invader in screen/pixel coordinates
     * @return Position of invader
     */
    public Vector2D getPosition()
    {
        return position;
    }
}
