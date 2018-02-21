/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.animation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import uni.Canvas;

/**
 * Class to hold data about an animation
 * @author mhops
 */
public class Animation 
{

    //The frames of the animation
    private ArrayList<Frame> frames;
    
    
    public Animation(String fileName) 
    {
        AnimationLoader loader = new AnimationLoader();
        frames = loader.loadAnimation(fileName);
    }
    
    protected abstract class Shape 
    {
        private boolean erase;
        
        Shape(boolean erase) 
        {
            this.erase = erase;
        }
        
        public void draw(Canvas canvas, double xOffset, double yOffset) 
        {
            onDraw(canvas, xOffset, yOffset, erase);
        }
        
        public abstract void onDraw(Canvas canvas, double xOffset, double yOffset, boolean erase);
    }
    
    protected class Rectangle extends Shape
    {
        private double x, y, width, height;
        
        public Rectangle(double x, double y, double width, double height, boolean erase)
        {
            super(erase);
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
        
        public void onDraw(Canvas canvas, double xOffset, double yOffset, boolean erase)
        {
            if (!erase)
                canvas.fillRectangle(x + xOffset, y + yOffset, width, height);
            else 
                canvas.eraseRectangle(x + xOffset, y + yOffset, width, height);
        }
    }
    
    protected class Polygon extends Shape
    {
        public Polygon(boolean erase)
        {
            super(erase);
        }

        @Override
        public void onDraw(Canvas canvas, double xOffset, double yOffset, boolean erase) 
        {
            
        }
    }
}
