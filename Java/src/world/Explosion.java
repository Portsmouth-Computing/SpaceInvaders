package world;

import uni.Canvas;
import util.Timer;
import world.animation.AnimationHandler;
import world.animation.AnimationType;

/**
 * Class to represent an explosion, which happens when an enemy dies
 * @author mhops
 */
public class Explosion 
{
    private Vector2D position;
    private Timer lifeTimer;
    private AnimationHandler animHandle;
    
    public Explosion(Vector2D expPosition)
    {
        lifeTimer = new Timer();
        position = expPosition;
        animHandle = new AnimationHandler(AnimationType.EXPLOSION.get(), 0.05f);
    }
    
    /**
     * Checks if the maximum lifetime of the explosion has been reached
     * @return If the explosion has reached its maximum lifetime
     */
    public boolean isLifetimeOver()
    {
        return lifeTimer.getTimeAsSeconds() >= 0.2;
    }
    
    /**
     * Draws the explosion
     * @param canvas Canvas to draw onto
     */
    public void draw(Canvas canvas)
    {   
        animHandle.draw(canvas, position.x, position.y, true);
    }
}
