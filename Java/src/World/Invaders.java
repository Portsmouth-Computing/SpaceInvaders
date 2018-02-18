/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package World;

import java.awt.Color;
import java.util.ArrayList;
import main.Game;
import uni.Canvas;

/**
 *
 * @author mhops
 */
public class Invaders 
{
    enum Direction 
    {
        LEFT,
        RIGHT
    }
    
    private int leftPosition;
    private int rightPosition;
    private final int minLeft;
    private final int maxRight;
    
    private Direction invaderDirection;
    private ArrayList<Invader> invaders;
    
    public Invaders()
    {
        leftPosition = 0;
        rightPosition = 0;
        minLeft = 100;
        maxRight = Game.WIDTH - minLeft;
        
        invaders = new ArrayList<>(50);
        leftPosition = Invader.SIZE + Game.WIDTH / 4;
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 12; x++) {
                double xPos = x * Invader.SIZE + x * 32 + Game.WIDTH / 4;
                double yPos = y * Invader.SIZE + y * 20 + Game.HEIGHT / 10;
                
                invaders.add(new Invader(new Vector2D(xPos, yPos)));
             
                rightPosition = Math.max(rightPosition, (int)xPos);
            }
        }
    }
    
    public void update()
    {
        double move = 2;
        double x = invaderDirection == Direction.LEFT ? -move : move;
        System.out.println("Left:  "  + leftPosition  + " " + minLeft + "\n" +
                           "Right: "  + rightPosition + " " + maxRight + "\n\n");
        
        leftPosition += x;
        rightPosition += x;
        
        boolean moveDown = false;
        if (leftPosition <= minLeft) {
            invaderDirection = Direction.RIGHT;
            moveDown = true;
        }
        else if (rightPosition >= maxRight) {
            invaderDirection = Direction.LEFT;
            moveDown = true;
        }
        
        for (Invader invader : invaders) {
            invader.move(x);
            if (moveDown) {
                invader.moveDown();
            }
        }  
    }
    
    public void drawAllInvaders(Canvas canvas)
    {
        canvas.setForegroundColor(Color.WHITE);
        for (Invader invader : invaders) {
            invader.draw(canvas);
        }
    }
}
