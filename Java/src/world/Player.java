package world;

import java.awt.Color;
import main.Game;
import uni.Canvas;
import world.animation.AnimationHandler;
import world.animation.AnimationType;

/**
 *
 * @author mhops
 */
public class Player 
{  
    public static final int WIDTH = 55, HEIGHT = 50;
    
    AnimationHandler lastUsed;
    AnimationHandler leftAnim;
    AnimationHandler rightAnim;
    BoundingBox box;
    Vector2D velocity;
    
    public Player()
    {
        leftAnim = new AnimationHandler(AnimationType.PLAYER_LEFT.get(), 0.1f);
        rightAnim = new AnimationHandler(AnimationType.PLAYER_RIGHT.get(), 0.1f);
        lastUsed = rightAnim;
        box = new BoundingBox(WIDTH, HEIGHT, 
                              Game.WIDTH / 2 - WIDTH / 2, Game.HEIGHT - 50);
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
        if (velocity.x > 0.2) {
            rightAnim.draw(canvas, box.getX(), box.getY(), true);
            lastUsed = rightAnim;
        } else if (velocity.x < -0.2) {
            leftAnim.draw(canvas, box.getX(), box.getY(), true);
            lastUsed = leftAnim;
        } else {
            lastUsed.draw(canvas, box.getX(), box.getY(), false);
            
        }
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
