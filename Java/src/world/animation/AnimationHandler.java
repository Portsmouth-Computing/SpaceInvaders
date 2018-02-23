package world.animation;

import uni.Canvas;
import util.Timer;

/**
 * Class to handle the rendering of an animation. 
 * Every drawable object has its own instance of this, which allows multiple
 * drawables to share the same animation object, while also having a unique timer, 
 * which is used to time the frames of the animations so it knows when to switch
 * to the next frame.
 * @author mhops
 */
public class AnimationHandler 
{
    private Animation animation;
    private Timer animationTimer;
    private float delay;
    private int currentFrame = 0;
    
    public AnimationHandler(Animation animation, float delay)
    {
        animationTimer = new Timer();
        this.animation = animation;
        this.delay = delay;
    }
    
    /**
     * Draws the animation, and may switch to the next animation frame
     * @param canvas Canvas to draw the animation onto
     * @param xPosition X-Coordinate to draw the animation to
     * @param yPostion Y-Coordinate to draw the animation to
     * @param progressFrames True if you want the animation to actually progress to next frame,
     *                       False if you do not
     */
    public void draw(Canvas canvas, double xPosition, double yPostion, boolean progressFrames) 
    {
        //Check if it has reached the next animation
        if (currentFrame == animation.getNumberFrames()) {
            currentFrame = 0; 
        }
        
        
        animation.draw(canvas, xPosition, yPostion, currentFrame);
        
        //Check if the timer has reached the delay between the animation frames
        if (animationTimer.getTimeAsSeconds() >= delay && progressFrames) {
            currentFrame++;
            animationTimer.reset();
        }
    }
}
