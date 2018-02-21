package world;

import java.awt.Color;
import uni.Canvas;
import world.animation.AnimationHandler;
import world.animation.AnimationType;

/**
 *
 * @author mhops
 */
public class Player 
{  
    public static final int WIDTH = 55;
    
    AnimationHandler renderer;
    BoundingBox box;
    Vector2D velocity;
    
    public Player()
    {
        renderer = new AnimationHandler(AnimationType.PLAYER.get(), 0.1f);
        box = new BoundingBox(55, 40, 500, 675);
        velocity = new Vector2D();
    }
    
    public void move(Vector2D vector)
    {
        velocity.add(vector);
    }
    
    public void update()
    {
        box.movePosition(velocity.x, velocity.y);
        velocity.x *= 0.93;
    }
    
    public void draw(Canvas canvas) 
    {
        canvas.setForegroundColor(Color.GREEN);
        renderer.draw(canvas, box.getX(), box.getY());
    }
    
    public Vector2D getPosition() 
    {
        return new Vector2D(box.getX(), box.getY());
    }
    
    public BoundingBox getBox()
    {
        return box;
    }
}
