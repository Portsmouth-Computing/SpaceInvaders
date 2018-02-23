package world.animation;

/**
 * Enum to hold the different animation types of the game
 * @author mhops
 */
public enum AnimationType 
{
    ENEMY_CLASSIC("res/EnemyClassic.txt"),
    ENEMY_SQUID("res/EnemySquid.txt"),
    ENEMY_SHELL("res/EnemyShell.txt"),
    EXPLOSION("res/Explosion.txt"),
    ENEMY_PROJ("res/EnemyProj.txt"),
    PLAYER_LEFT("res/PlayerLeft.txt"),
    PLAYER_RIGHT("res/PlayerRight.txt");
    
    private final Animation animation;
    
    AnimationType(String file)
    {
        this.animation = new Animation(file);
    }
    
    public Animation get()
    {
        return animation;
    }
    
}
