package gui;

import world.BoundingBox;

/**
 *
 * @author mhops
 */
public abstract class MenuComponent 
{
    protected BoundingBox bounds;
    
    protected MenuComponent(double x, double y, double width, double height)
    {
        bounds = new BoundingBox(width, height, x, y);
    }
}
