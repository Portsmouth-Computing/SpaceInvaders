/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.animation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import uni.Canvas;

/**
 * Class to hold data about an animation
 * @author mhops
 */
public class Animation 
{

    //The frames of the animation
    private ArrayList<Frame> frames;
    
    
    public Animation(String fileName) 
    {
        AnimationLoader loader = new AnimationLoader();
        frames = loader.loadAnimation(fileName);
    }
    
    public void draw(Canvas c, double x, double y) 
    {
        frames.get(0).draw(c, x, y);
    }
}
