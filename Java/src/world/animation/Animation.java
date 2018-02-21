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
public class Animation 
{
    protected class Rectangle
    {
        private double x, y, width, height;
        
        public Rectangle(double x, double y, double width, double height)
        {
            
        }
        
        public void draw(Canvas canvas, double xOffset, double yOffset, boolean erase)
        {
            if (!erase)
                canvas.fillRectangle(x + xOffset, y + yOffset, width, height);
            else 
                canvas.eraseRectangle(x + xOffset, y + yOffset, width, height);
        }
    }
    
    private ArrayList<Frame> frames;
    
    
    public Animation(String fileName) 
    {
        frames = new ArrayList<>();
    }
    
   
}
