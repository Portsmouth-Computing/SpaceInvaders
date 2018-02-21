package world;

/**
 *
 * @author mhops
 */
public class HitResult 
{
    private boolean isHit;
    private Vector2D location;
    
    public HitResult(boolean isHit, Vector2D position)
    {
        this.isHit = isHit;
        this.location = position;
    }
    
    public boolean getIsHit() 
    {
        return isHit;
    }
    
    public Vector2D getHitLocation()
    {
        return location;
    }
}
