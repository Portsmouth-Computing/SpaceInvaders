/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import world.BoundingBox;
import world.Vector2D;

/**
 *
 * @author mhops
 */
public class Button 
{
    ButtonCallback funcion;
    BoundingBox bounds;
    String text;
    
    public Button(int x, int y, int width, int height, String text, ButtonCallback function)
    {
        this.bounds = new BoundingBox(x, y, width, height);
        this.text = text;
        this.funcion = function;
    }
    
    public boolean clicked(Vector2D pos)
    {
        funcion.function();
        return false;
    }
}
