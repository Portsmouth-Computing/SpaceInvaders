package state;

import world.Invaders;
import world.Player;
import world.Vector2D;
import java.awt.event.KeyEvent;
import main.Game;
import uni.Canvas;

/**
 * State for playing the game
 * @author mhops
 */
public class PlayingState extends GameState 
{
    private Player player;
    private Invaders invaders;
    
    public PlayingState(Game game) 
    {
        super(game);
        player = new Player();
        invaders = new Invaders();
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
       if (key == KeyEvent.VK_SPACE) {
           //Shoot
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
    }
}
