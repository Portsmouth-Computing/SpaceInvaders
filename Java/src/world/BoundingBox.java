/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

/**
 *
 * @author mhops
 */
public class BoundingBox 
{
    private double width,
                   height,
                   x,
                   y;
    
    public BoundingBox(double width, double height, double x, double y) 
    {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }
    
    public double getX()
    {
        return x;
    }
    
    public double getY()
    {
        return y;
    }
    
    public double getWidth()
    {
        return width;
    }
    
    public double getHeight() 
    {
        return height;
    }
    
    public void movePosition(double xOffset, double yOffset)
    {
        x += xOffset;
        y += yOffset;
    }
    
    public void updatePosition(double newX, double newY)
    {
        x = newX;
        y = newY;
    }
    
    public boolean isColliding(BoundingBox other) 
    {
        return  x < other.x + other.width &&
                y < other.y + other.height &&
                x + width   > other.x &&
                y + height  > other.y;
    }
}
