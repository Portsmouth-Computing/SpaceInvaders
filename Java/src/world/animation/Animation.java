package world.animation;

import java.util.ArrayList;
import uni.Canvas;

/**
 * Class to hold data about an animation
 * @author mhops
 */
public class Animation 
{

    //The frames of the animation
    private ArrayList<Frame> frames;
    
    public Animation(String fileName) 
    {
        AnimationLoader loader = new AnimationLoader();
        frames = loader.loadAnimation(fileName);
    }
    
    public void draw(Canvas c, double x, double y, int frame) 
    {
        frames.get(frame).draw(c, x, y);
    }
    
    public int getNumberFrames()
    {
        return frames.size();
    }
}
