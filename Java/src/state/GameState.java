package state;

import java.awt.event.KeyEvent;
import main.Game;
import uni.Canvas;
import world.Vector2D;

/**
 * Base game state class
 * @author mhops
 */
public abstract class GameState 
{
    private Game game;
    
    public GameState(Game game) 
    {
        this.game = game;
    }
  
    public abstract void handleMouseClick(int button, Vector2D location);
    public abstract void handleKeyPress(int key);
    public abstract void handleKeyUp(int key);
    public abstract void update();
    public abstract void draw(Canvas canvas);
   
    /**
      * Gets the game handle
      * @return The main class of the game
      */
    protected Game getGame()
    {
        return game;
    }
}
