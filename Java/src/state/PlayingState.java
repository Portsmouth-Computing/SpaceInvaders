/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import java.awt.event.KeyEvent;
import main.Game;

/**
 * State for playing the game
 * @author mhops
 */
public class PlayingState extends GameState 
{
    
    public PlayingState(Game game) 
    {
        super(game);
        
    }
    
    @Override
    public void handleInput(KeyEvent e) 
    {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Left key pressed");
        }
    }

    @Override
    public void update() 
    {
        
    }

    @Override
    public void draw() {
        
    }
    
}
