/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package World;

import java.awt.Color;
import uni.Canvas;

/**
 *
 * @author mhops
 */
public class Player 
{  
    Vector2D position;
    Vector2D velocity;
    
    public Player()
    {
        velocity = new Vector2D();
        position = new Vector2D(500.0, 500.0);
    }
    
    public void move(Vector2D vector)
    {
        velocity.add(vector);
    }
    
    public void update()
    {
        position.add(velocity);
        velocity.x *= 0.93;
    }
    
    public void draw(Canvas canvas) 
    {
        canvas.setForegroundColor(Color.GREEN);
        canvas.fillRectangle(position.x, position.y, 50, 50);
    }
}
