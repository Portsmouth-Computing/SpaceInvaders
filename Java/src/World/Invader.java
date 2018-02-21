package world;

import uni.Canvas;
import util.Timer;

/**
 * Represents an invader/ enemy of the game
 * @author mhops
 */
public class Invader 
{
    public static final int WIDTH = 55;
    public static final int HEIGHT = 40;
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
            if (animTimer.getTimeAsSeconds() > 0.75) {
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
        double x = box.getX();
        double y = box.getY();
        //ears
        canvas.fillRectangle(x + 10, y, 5, 5);
        canvas.fillRectangle(x + 40, y, 5, 5);
        canvas.fillRectangle(x + 15, y + 5, 5, 5);
        canvas.fillRectangle(x + 35, y + 5, 5, 5);
        
        //body
        canvas.fillRectangle(x + 10, y + 10, 35, 20);
        
        //arms
        canvas.fillRectangle(x + 5, y + 15, 5, 10);
        canvas.fillRectangle(x + 45, y + 15, 5, 10);
        canvas.fillRectangle(x, y + 20, 5, 15);
        canvas.fillRectangle(x + 50, y + 20, 5, 15);
        
        //mouth
        canvas.fillRectangle(x + 10, y + 30, 5, 5);
        canvas.fillRectangle(x + 40, y + 30, 5, 5);
        canvas.fillRectangle(x + 15, y + 35, 10, 5);
        canvas.fillRectangle(x + 30, y + 35, 10, 5);
        
        //eyes
        canvas.eraseRectangle(x + 15, y + 15, 5, 5);
        canvas.eraseRectangle(x + 35, y + 15, 5, 5);
    }
    
    private void drawFrame1(Canvas canvas) 
    {
        double x = box.getX();
        double y = box.getY();
        //ears
        canvas.fillRectangle(x + 10, y, 5, 5);
        canvas.fillRectangle(x + 40, y, 5, 5);
        canvas.fillRectangle(x + 15, y + 5, 5, 5);
        canvas.fillRectangle(x + 35, y + 5, 5, 5);
        
        //body
        canvas.fillRectangle(x + 10, y + 10, 35, 20);
        
        //arms
        canvas.fillRectangle(x + 5, y + 15, 5, 10);
        canvas.fillRectangle(x + 45, y + 15, 5, 10);
        
        canvas.fillRectangle(x, y + 5, 5, 15);
        canvas.fillRectangle(x + 50, y + 5, 5, 15);
        
        //mouth
        canvas.fillRectangle(x + 10, y + 30, 5, 5);
        canvas.fillRectangle(x + 40, y + 30, 5, 5);
        canvas.fillRectangle(x + 15, y + 35, 10, 5);
        canvas.fillRectangle(x + 30, y + 35, 10, 5);
        
        //eyes
        canvas.eraseRectangle(x + 15, y + 15, 5, 5);
        canvas.eraseRectangle(x + 35, y + 15, 5, 5);
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
