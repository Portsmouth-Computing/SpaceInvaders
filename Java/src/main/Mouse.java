package main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import world.Vector2D;

/**
 *
 * @author mhops
 */
public class Mouse extends MouseAdapter
{
    private StateManager states;
    
    public Mouse(StateManager states)
    {
        this.states = states;
    }
    
    public void mouseClicked(MouseEvent e)
    {
        int x = e.getPoint().x;
        int y = e.getPoint().y;
        states.peekState().handleMouseClick(e.getButton(), new Vector2D(x, y));
    }
}
