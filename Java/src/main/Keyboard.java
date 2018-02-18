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
        states.peekState().handleInput(e);
    }

    @Override
    public void keyReleased(KeyEvent e) { }
    @Override
    public void keyTyped(KeyEvent e) { }
}
