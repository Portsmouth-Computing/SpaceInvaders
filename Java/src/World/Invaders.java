/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package World;

import java.awt.Color;
import java.util.ArrayList;
import uni.Canvas;

/**
 *
 * @author mhops
 */
public class Invaders 
{
    private ArrayList<Invader> invaders;
    
    public Invaders()
    {
        invaders = new ArrayList<>(50);
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 10; x++) {
                double xPos = x * Invader.SIZE + 10;
                double yPos = y * Invader.SIZE + 10;
                
                invaders.add(new Invader(new Vector2D(xPos, yPos)));
            }
        }
    }
    
    public void update()
    {
        
    }
    
    public void drawAllInvaders(Canvas canvas)
    {
        canvas.setForegroundColor(Color.WHITE);
        for (Invader invader : invaders) {
            invader.draw(canvas);
        }
    }
}
