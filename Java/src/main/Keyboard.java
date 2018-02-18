package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Handles keyboard input 
 * @author mhops
 */
public class Keyboard implements KeyListener
{
    private StateManager states;
    
    public Keyboard(StateManager states)
    {
        this.states = states;
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        states.peekState().handleKeyPress(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) 
    { 
        states.peekState().handleKeyUp(e.getKeyCode());
    }
    
    @Override
    public void keyTyped(KeyEvent e) { }
}
