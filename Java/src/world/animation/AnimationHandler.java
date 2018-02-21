package world.animation;

import uni.Canvas;
import util.Timer;

/**
 *
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
    
    public void draw(Canvas c, double xPosition, double yPostion) 
    {
        if (currentFrame == animation.getNumberFrames()) {
            currentFrame = 0; 
        }
        
        animation.draw(c, xPosition, yPostion, currentFrame);
        if (animationTimer.getTimeAsSeconds() >= delay) {
            currentFrame++;
            animationTimer.reset();
        }
    }
}
