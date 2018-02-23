
package world;

/**
 * Class to represent a box which has a 2D position, a width, and a height
 * @author mhops
 */
public class BoundingBox 
{
    private double width,
                   height,
                   x,
                   y;
    
    /**
     * Constructs the bounding box
     * @param width Width of the box
     * @param height Height of the box
     * @param x initial X Position of the box top left point
     * @param y initial Y Position of the box top left point
     */
    public BoundingBox(double width, double height, double x, double y) 
    {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }
    
    //Getters
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
    
    /**
     * Moves the box
     * @param xOffset Amount to move box by in X-Direction
     * @param yOffset Amount to move box by in Y-Direction
     */
    public void movePosition(double xOffset, double yOffset)
    {
        x += xOffset;
        y += yOffset;
    }
    
    /**
     * Sets a new position for the box to be
     * @param newX The new x-coordinate of the box top left
     * @param newY The new y-coordinate of the box top left
     */
    public void updatePosition(double newX, double newY)
    {
        x = newX;
        y = newY;
    }
    
    /**
     * Checks if the box is intersecting another box
     * @param other The other box to check collisions with
     * @return True if the two boxes are colliding
     */
    public boolean isColliding(BoundingBox other) 
    {
        return  x < other.x + other.width &&
                y < other.y + other.height &&
                x + width   > other.x &&
                y + height  > other.y;
    }
    
    /**
     * Checks if the box contains a point coordinate
     * @param point The point to check is inside the box
     * @return True if the point passed in is inside the box
     */
    public boolean containsPoint(Vector2D point) 
    {
        return point.x > x &&
               point.y > y &&
               point.x < x + width &&
               point.y < y + height;
                      
    }
}
