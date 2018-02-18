/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import java.awt.event.KeyEvent;
import main.Game;
import uni.Canvas;

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
  
   public abstract void handleInput(KeyEvent e);
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
