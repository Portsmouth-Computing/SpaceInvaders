/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import java.awt.event.KeyEvent;
import main.Game;

/**
 * Base game state class
 * @author mhops
 */
public abstract class GameState 
{
    private Game game;
    
   public  GameState(Game game) 
   {
       this.game = game;
   }
  
   public abstract void handleInput(KeyEvent e);
   public abstract void update();
   public abstract void draw();
   
   protected Game getGame()
   {
       return game;
   }
}
