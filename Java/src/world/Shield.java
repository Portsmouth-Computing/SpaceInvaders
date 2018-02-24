package world;

import main.Game;
import uni.Canvas;
import util.BoundingBox;

/**
 * Represents s shield/ barricade between the player and the aliens
 * @author mhops
 */
public class Shield 
{ 
    public final static int HEIGHT = 100;
    public final static int WIDTH = 200;
    public final static int MAX_HEALTH = 5;
    
    private BoundingBox box;
    private int health;
    
    public Shield(int xPosition) 
    {
        box = new BoundingBox(WIDTH, HEIGHT, xPosition, Game.HEIGHT - 200);
        health = 5;
    }
    
    public BoundingBox getBox()
    {
        return box;
    }
    
    private void hit()
    {
        health--;
    }
    
    public boolean isDestroyed()
    {
        return health == 0;
    }
    
    public void draw(Canvas canvas)
    {
        int h = HEIGHT - ((MAX_HEALTH - health) * HEIGHT / MAX_HEALTH);
        
        canvas.fillRectangle(box.getX(), box.getY(), WIDTH, h);
    }
    
    public HitResult collidingProjectile(Projectile projectile)
    {
        if (box.isColliding(projectile.getBox())) {
            System.out.println("hit");
            hit();
            return new HitResult(true, projectile.getBox().getPosition());
        } else {
            return new HitResult(false, null);
        }
                
    }
}
