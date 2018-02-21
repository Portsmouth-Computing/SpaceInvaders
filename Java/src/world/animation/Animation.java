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

    
    private ArrayList<Frame> frames;
    
    
    public Animation(String fileName) 
    {
        frames = new ArrayList<>();
        loadAnimation(fileName);
    }
    
    private void loadAnimation(String fileName) 
    {
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            BufferedReader buffReader = new BufferedReader(reader);
            String line;
            while ((line = buffReader.readLine()) != null) {
                readLine(line);
            }
            reader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    private void readLine(String line) 
    {
        String[] tokens = line.split("\\s+");
        String id = tokens[0];
        
    }
    
    private void loadRectangle(String[] tokens, boolean erase) 
    {
        
    }
    
    protected class Rectangle
    {
        private double x, y, width, height;
        
        public Rectangle(double x, double y, double width, double height)
        {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
        
        public void draw(Canvas canvas, double xOffset, double yOffset, boolean erase)
        {
            if (!erase)
                canvas.fillRectangle(x + xOffset, y + yOffset, width, height);
            else 
                canvas.eraseRectangle(x + xOffset, y + yOffset, width, height);
        }
    }
    
    protected class Polygon
    {
        public Polygon()
        {
            
        }
    }
}
