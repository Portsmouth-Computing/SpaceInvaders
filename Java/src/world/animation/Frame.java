/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.animation;

import java.util.ArrayList;
import uni.Canvas;

/**
 *
 * @author mhops
 */
public class Frame
{
    private ArrayList<Shapes.Shape> shapes;
    
    public Frame() 
    {
        shapes = new ArrayList<>();
    }
        
    public void addShape(Shapes.Shape shape)
    {
        shapes.add(shape);
    }
    
    public void drawFrame(Canvas canvas, double xOffset, double yOffset)
    {
        for (Shapes.Shape shape : shapes) {
            shape.draw(canvas, xOffset, yOffset);
        }
    }
}
