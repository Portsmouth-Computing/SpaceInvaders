package state;

import java.awt.Color;
import world.Invaders;
import world.Player;
import world.Vector2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import main.Game;
import uni.Canvas;
import util.Timer;
import world.Projectile;

/**
 * State for playing the game
 * @author mhops
 */
public class PlayingState extends GameState 
{
    private ArrayList<Projectile> worldProjectiles;
    
    private Player player;
    private Invaders invaders;
    private Timer shootTimer;
    
    public PlayingState(Game game) 
    {
        super(game);
        worldProjectiles = new ArrayList<>();
        player = new Player();
        invaders = new Invaders();
        shootTimer = new Timer();
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
       System.out.println(shootTimer.getTimeAsSeconds() );
        if (shootTimer.getTimeAsSeconds() >= 0.5) {
             if (key == KeyEvent.VK_SPACE) {
                 worldProjectiles.add(new Projectile(player.getPosition(), -5));
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
        
        canvas.setForegroundColor(Color.RED);
        for(Projectile proj : worldProjectiles) {
            proj.draw(canvas);
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
        Iterator itr = worldProjectiles.iterator();
        while(itr.hasNext()) {
            Projectile proj = (Projectile)itr.next();
            proj.update();
            
            if (proj.isTargettingPlayer()) {
                
            } else {
                if (invaders.invaderCollidesWithProjectile(proj)) {
                    itr.remove();
                    continue;
                }
            }
            
            if (proj.shouldBeRemoved()) {
                itr.remove();
            }
        }
    }
}
