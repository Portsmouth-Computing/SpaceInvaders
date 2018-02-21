/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.animation;

import java.util.ArrayList;

/**
 *
 * @author mhops
 */
public class Frame
{
    private ArrayList<Animation.Rectangle> fillRects;
    private ArrayList<Animation.Rectangle> eraseRects;
    
    public Frame() 
    {
        fillRects = new ArrayList<>();
        eraseRects = new ArrayList<>();
    }
        
    public void addFillRect(Animation.Rectangle rectangle)
    {
        fillRects.add(rectangle);
    }
    
    public void addEraseRect(Animation.Rectangle rectangle)
    {
        eraseRects.add(rectangle);
    }
    
    
}
