package world;

import util.Vector2D;

/**
 * Class to hold the result of an enemy getting hit
 * @author mhops
 */
public class HitResult 
{
    public static final HitResult FAIL = new HitResult(false, null);
    private final boolean isHit;
    private final Vector2D location;
    
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
