/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import World.Player;
import World.Vector2D;
import java.awt.event.KeyEvent;
import main.Game;
import uni.Canvas;

/**
 * State for playing the game
 * @author mhops
 */
public class PlayingState extends GameState 
{
    Player player;
    
    public PlayingState(Game game) 
    {
        super(game);
        player = new Player();
    }
    
    /**
     * Handles the input of the current state
     * @param e KeyEvent event to get the key pressed
     */
    @Override
    public void handleInput(KeyEvent e) 
    {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.move(new Vector2D(-1, 0));
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.move(new Vector2D(1, 0));
        }
    }

    /**
     * Update the game
     */
    @Override
    public void update() 
    {
        player.update();
    }

    /**
     * Draw everything in the game
     */
    @Override
    public void draw(Canvas canvas) 
    {
        player.draw(canvas);
    }
    
}
