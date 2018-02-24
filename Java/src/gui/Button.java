package gui;

import uni.Canvas;
import world.BoundingBox;
import world.Vector2D;

/**
 *
 * @author mhops
 */
public class Button 
{
    ButtonCallback function;
    BoundingBox bounds;
    String text;
    
    public Button(int x, int y, int width, int height, String text, ButtonCallback function)
    {
        this.bounds = new BoundingBox(width, height, x, y);
        this.text = text;
        this.function = function;
    }
    
    public void onClick(Vector2D pos)
    {
        if (bounds.containsPoint(pos)){
            function.function();
        }
    }
    
    public void draw(Canvas canvas) 
    {
        canvas.fillRectangle(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
    }
}
