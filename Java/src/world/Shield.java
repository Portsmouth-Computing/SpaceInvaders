package world;

import java.util.ArrayList;
import main.Game;
import uni.Canvas;
import util.BoundingBox;
import util.Vector2D;

/**
 * Represents s shield/ barricade between the player and the aliens
 * @author mhops
 */
public class Shield 
{ 
    private class ShieldSection
    {
        public final static int HEIGHT = 100;
        public final static int WIDTH = 40;
        public final static int MAX_HEALTH = 10;

        private BoundingBox box;
        private int health;

        public ShieldSection(int xPosition) 
        {
            box = new BoundingBox(WIDTH, HEIGHT, xPosition, Game.HEIGHT - 200);
            health = MAX_HEALTH;
        }

        public BoundingBox getBox()
        {
            return box;
        }

        private void hit()
        {
            health--;
            box.setHeight(box.getHeight() - HEIGHT / MAX_HEALTH);
        }
        
        public boolean isDestroyed()
        {
            return health <= 0;
        }

        public void draw(Canvas canvas)
        {
            int h = HEIGHT - ((MAX_HEALTH - health) * HEIGHT / MAX_HEALTH);

            canvas.fillRectangle(box.getX(), box.getY(), WIDTH, h);
        }

        public HitResult collidingProjectile(Projectile projectile)
        {
            if (box.isColliding(projectile.getBox())) {
                hit();
                double x = projectile.getBox().getX() + Projectile.WIDTH / 2;
                double y = projectile.getBox().getY();
                if (projectile.isTargetingPlayer()) {
                   box.movePosition(0, HEIGHT / MAX_HEALTH);
                }
                return new HitResult(true, new Vector2D(x, y));
            } else {
                return new HitResult(false, null);
            }
        }
    }

    private final static int WIDTH = 200;
    private final static int NUM_SECTIONS = WIDTH / ShieldSection.WIDTH;
    private ArrayList<ShieldSection> sheildSections;
    
    public Shield(int xPosition) 
    {
        sheildSections = new ArrayList<>(NUM_SECTIONS);
        for (int i = 0; i < NUM_SECTIONS; i++) {
            sheildSections.add(
                    new ShieldSection(xPosition + i * ShieldSection.WIDTH));
        }
    }
    
    
    public void draw(Canvas canvas)
    {
        for (ShieldSection section : sheildSections) {
            section.draw(canvas);
        }
    }
    
    public HitResult collidingProjectile(Projectile projectile)
    {
        for (ShieldSection section : sheildSections) {
            if (section.isDestroyed()) continue;
            HitResult r = section.collidingProjectile(projectile);
            if (r.getIsHit()) {
                return r;
            }
        }        
        return new HitResult(false, null);
    }
}
