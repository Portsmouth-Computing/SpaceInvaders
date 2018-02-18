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
    
    private BoundingBox box;
    
    public Invader(Vector2D position)
    {
        box = new BoundingBox(SIZE, SIZE, position.x, position.y);
    }
    
    /**
     * Draws the invader
     * @param canvas The canvas to draw the invader onto
     */
    public void draw(Canvas canvas)
    {
        if (isAlive) {
            canvas.fillRectangle(box.getX(), box.getY(), SIZE, SIZE);
        }
    }
    
    /**
     * Moves the invaders X-Position by the given parameter
     * @param xOffset The amount to offset the invader by in X-Axis
     */
    public void move(double xOffset)
    {
        box.updatePosition(box.getX() + xOffset, box.getY());
    }
    
    /**
     * Moves the invader down to the next row
     */
    public void moveDown()
    {
        box.updatePosition(box.getX(), box.getY() + SIZE / 2);
    }
    
    /**
     * Gets whether the invader is still alive
     * @return whether the invader is alive
     */
    public boolean getIsAlive() 
    {
        return isAlive;
    }
    
    public BoundingBox getBox()
    {
        return box;
    }
    
    /**
     * Gets the position of the invader in screen/pixel coordinates
     * @return Position of invader
     */
    public Vector2D getPosition()
    {
        return new Vector2D(box.getX(), box.getY());
    }
    
    public void kill()
    {
        isAlive = false;
    }
}
