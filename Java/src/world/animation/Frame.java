package world.animation;

import java.util.ArrayList;
import uni.Canvas;

/**
 * Class to represent a single frame of an animation
 * @author mhops
 */
public class Frame
{
    private ArrayList<Shapes.Shape> shapes;
    
    public Frame() 
    {
        shapes = new ArrayList<>();
    }
        
    public void addShape(Shapes.Shape shape)
    {
        shapes.add(shape);
    }
    
    public void draw(Canvas canvas, double xOffset, double yOffset)
    {
        for (Shapes.Shape shape : shapes) {
            shape.draw(canvas, xOffset, yOffset);
        }
    }
}
