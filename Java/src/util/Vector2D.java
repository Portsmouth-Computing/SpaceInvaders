package util;

/**
 *
 * @author mhops
 */
public class Vector2D 
{
    public double x;
    public double y;
        
    public Vector2D()
    {
       this(0.0, 0.0);
    }
        
    public Vector2D(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
        
    public void add(Vector2D other) 
    {
        this.x += other.x;
        this.y += other.y;
    }
    
    public Vector2D copy()
    {
        return new Vector2D(x, y);
    }
}
