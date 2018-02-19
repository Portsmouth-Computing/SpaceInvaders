package world;

import uni.Canvas;
import util.Timer;

/**
 * Represents an invader/ enemy of the game
 * @author mhops
 */
public class Invader 
{
    public static final int WIDTH = 50;
    public static final int HEIGHT = 25;
    public boolean isAlive = true;
    
    private Timer animTimer;
    public int tAnimFrame = 0;
    
    private BoundingBox box;
    
    public Invader(Vector2D position)
    {
        box = new BoundingBox(WIDTH, HEIGHT, position.x, position.y);
        animTimer = new Timer();
    }
    
    /**
     * Draws the invader
     * @param canvas The canvas to draw the invader onto
     */
    public void draw(Canvas canvas)
    {
        if (isAlive) {
            if (animTimer.getTimeAsSeconds() > 1) {
                tAnimFrame++;
                animTimer.reset();
                if (tAnimFrame > 1) {
                    tAnimFrame = 0;
                }
            }
            switch(tAnimFrame) {
                case 0:
                    drawFrame0(canvas);
                    break;
                
                case 1:
                    drawFrame1(canvas);
                    break;
            }
            
        }
    }
    
    private void drawFrame0(Canvas canvas)
    {
        canvas.fillRectangle(box.getX(), box.getY(), WIDTH, HEIGHT);
    }
    
    private void drawFrame1(Canvas canvas) 
    {
        canvas.fillRectangle(box.getX(), box.getY(), WIDTH, HEIGHT - 10);
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
        box.updatePosition(box.getX(), box.getY() + WIDTH / 2);
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
     * Gets the bounding box of this invader
     * @return Bounding box of this invader
     */
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
    
    /**
     * Kills the invader, so it doesn't draw anymore etc
     */
    public void kill()
    {
        isAlive = false;
    }
}
