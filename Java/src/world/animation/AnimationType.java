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
    ENEMY_CLASSIC("res/Invader.txt"),
    ENEMY_SQUID("res/Invader2.txt"),
    EXPLOSION("res/Explosion.txt"),
    ENEMY_PROJ("res/EnemyProj.txt"),
    PLAYER("res/Player.txt");
    
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
