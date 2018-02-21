package world;

import java.util.Random;
import uni.Canvas;
import util.Timer;
import world.animation.Animation;
import world.animation.AnimationHandler;

/**
 * Represents an invader/ enemy of the game
 * @author mhops
 */
public class Invader 
{
    AnimationHandler renderer;
    
    public static final int WIDTH = 55;
    public static final int HEIGHT = 40;
    public boolean isAlive = true;
    
    private BoundingBox box;
    
    public Invader(Animation anim, Vector2D position)
    {
        box = new BoundingBox(WIDTH, HEIGHT, position.x, position.y);
        renderer = new AnimationHandler(anim, 0.65f);
    }
    
    /**
     * Draws the invader
     * @param canvas The canvas to draw the invader onto
     */
    public void draw(Canvas canvas)
    {
        if (isAlive) {
            renderer.draw(canvas, box.getX(), box.getY());
        }
    }
    
    /**
     * Moves the invaders X-Position by the given parameter
     * @param xOffset The amount to offset the invader by in X-Axis
     */
    public void move(double xOffset)
    {
        box.movePosition(xOffset, 0);
    }
    
    /**
     * Moves the invader down to the next row
     */
    public void moveDown()
    {
        box.movePosition(0, WIDTH / 2);
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
