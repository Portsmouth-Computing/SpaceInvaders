/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
