package state;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import uni.Canvas;
import main.Game;
import util.Timer;
import world.Invaders;
import world.Player;
import world.Explosion;
import world.HitResult;
import world.Projectile;
import util.Vector2D;
import world.Shield;

/**
 * State for playing the game
 * @author mhops
 */
public class PlayingState extends GameState 
{
    private ArrayList<Projectile> worldProjectiles;
    private ArrayList<Explosion> explosions;
    private ArrayList<Shield> shields;
    private Player player;
    private Invaders invaders;
    private Timer shootTimer;
    
    public PlayingState(Game game) 
    {
        super(game);
        worldProjectiles = new ArrayList<>();
        explosions = new ArrayList<>();
        shields = new ArrayList<>();
        player = new Player();
        invaders = new Invaders();
        shootTimer = new Timer();
        
        for (int i = 0; i < 3; i++) 
        {
            shields.add(new Shield(i * Game.WIDTH / 3 + 100));
        }
    }
    
    @Override
    public void handleMouseClick(int button, Vector2D location) 
    {
        System.out.println("Mouse clicked: " + location.x + " " + location.y);
    }
    
    /**
     * Handles the real time keyboard input
     * @param key The key being pressed
     */
    @Override
    public void handleKeyPress(int key) 
    {
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            player.move(new Vector2D(-1, 0));
        }
        else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            player.move(new Vector2D(1, 0));
        }
    }
    
    /**
     * Handles the a key being released
     * @param key The key that was released
     */
    @Override
    public void handleKeyUp(int key) 
    {
        //Tries to shoot from the player's position
        if (shootTimer.getTimeAsSeconds() >= 0.01) {
             if (key == KeyEvent.VK_SPACE) {
                 double x = player.getPosition().x + Player.WIDTH / 2 - 
                            Projectile.WIDTH / 2;
                 double y = player.getPosition().y + 10;
                 worldProjectiles.add(new Projectile(new Vector2D(x, y), -10));
             }
             shootTimer.reset();
        }
    }

    /**
     * Update the game
     */
    @Override
    public void update() 
    {
        player.update();
        invaders.move();
        Projectile newProjectile = invaders.tryShoot();
        if (newProjectile != null) {
            worldProjectiles.add(newProjectile);
        }
        
        updateProjectiles();
    }

    /**
     * Draw everything in the game
     * @param canvas The canvas to draw onto
     */
    @Override
    public void draw(Canvas canvas) 
    {
        player.draw(canvas);
        invaders.draw(canvas);
        
        canvas.setForegroundColor(Color.GRAY);
        shields.forEach((shield) -> {
            shield.draw(canvas);
        });
        
        canvas.setForegroundColor(Color.RED);
        worldProjectiles.forEach((proj) -> {
            proj.draw(canvas);
        });
        
        canvas.setForegroundColor(Color.WHITE);
        Iterator<Explosion> itr = explosions.iterator();
        while(itr.hasNext()) {
            Explosion exp = itr.next();
            if (exp.isLifetimeOver()) {
                itr.remove();
            } else {
                exp.draw(canvas);
            }
        }
    }
    
    /**
     * Updates the projectiles by:
     * -Removing destroyed ones
     * -Moving them
     * -Testing for collision with entities
     */
    private void updateProjectiles()
    {
        Iterator<Projectile> itr = worldProjectiles.iterator();
        while(itr.hasNext()) {
            Projectile proj = itr.next();
            proj.update();
            
            if (proj.isTargetingPlayer()) {
                if (player.getBox().isColliding(proj.getBox())) {
                    itr.remove();
                    continue;
                }
            } else {
                HitResult invRes = invaders.invaderCollidesWithProjectile(proj);
                
                if (invRes.getIsHit()) {
                    itr.remove();
                    explosions.add(new Explosion(invRes.getHitLocation()));
                    continue;
                }
            }
            HitResult shiRes = collideProjectileWithShield(proj);
            if (shiRes.getIsHit()) {
                itr.remove();
                explosions.add(new Explosion(shiRes.getHitLocation()));
                continue;
            }
            if (proj.shouldBeRemoved()) {
                itr.remove();
            }
        }
    }
    
    private HitResult collideProjectileWithShield(Projectile proj)
    {
        for (Shield shield : shields) {
            HitResult r = shield.collidingProjectile(proj);
            if (r.getIsHit()) {
                return r;
            }
        }
        return new HitResult(false, null);
    }
}
