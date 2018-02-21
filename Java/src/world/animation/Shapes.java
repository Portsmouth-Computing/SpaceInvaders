/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.animation;

import uni.Canvas;

/**
 * Bunch 
 * @author mhops
 */
public class Shapes 
{
    protected static abstract class Shape 
    {
        private final boolean erase;
        
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
    
    protected static class Rectangle extends Shape
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
        
        /**
         *
         * @param canvas
         * @param xOffset
         * @param yOffset
         * @param erase
         */
        @Override
        public void onDraw(Canvas canvas, double xOffset, double yOffset, boolean erase)
        {
            if (!erase)
                canvas.fillRectangle(x + xOffset, y + yOffset, width, height);
            else 
                canvas.eraseRectangle(x + xOffset, y + yOffset, width, height);
        }
    }
    
    protected static class Polygon extends Shape
    {
        private double[] xPositions;
        private double[] yPositions;
        
        public Polygon(double[] xPositions, double[] yPositions, boolean erase)
        {
            super(erase);
            this.xPositions = xPositions;
            this.yPositions = yPositions;
        }

        @Override
        public void onDraw(Canvas canvas, double xOffset, double yOffset, boolean erase) 
        {
            if (!erase)
                canvas.fillPolygon(xPositions, yPositions);
            else 
                canvas.erasePolygon(xPositions, yPositions);
        }
    }
}
