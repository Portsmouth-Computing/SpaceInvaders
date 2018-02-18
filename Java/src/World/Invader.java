/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package World;

import uni.Canvas;

/**
 *
 * @author mhops
 */
public class Invader 
{
    public static final int SIZE = 50;
    
    private Vector2D position;
    
    public Invader(Vector2D initialPosition)
    {
        position = initialPosition;
    }
    
    public void draw(Canvas canvas)
    {
        canvas.fillRectangle(position.x, position.y, SIZE, SIZE);
    }
}
