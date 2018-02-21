/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.animation;

/**
 *
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
