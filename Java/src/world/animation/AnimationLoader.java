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

/**
 *
 * @author mhops
 */
public class AnimationLoader 
{
    ArrayList<Frame> frames;
    Frame currentFrame;
    boolean loadingFrame;
    boolean end;
    
    public AnimationLoader()
    {
        frames = new ArrayList<>();
        currentFrame = null;
        loadingFrame = false;
        end = false;
    }
    
    public ArrayList<Frame> loadAnimation(String fileName) 
    {
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            BufferedReader buffReader = new BufferedReader(reader);
            String line;
            while (((line = buffReader.readLine()) != null) && !end) {
                readLine(line);
            }
            reader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        return frames;
    }
    
    private void readLine(String line) 
    {
        String[] tokens = line.split("\\s+");
        String id = tokens[0];
        if (loadingFrame) {
            switch(id) {
                case "R":
                    loadRectangle(tokens, false);
                    break;
                    
                case "ER":
                    loadRectangle(tokens, true);
                    break;
                    
                case "P":
                    //loadPolygon(tokens, false);
                    break;
                    
            }
        } else {
            if (id.equals("FRAME")) {
                currentFrame = new Frame();
                loadingFrame = true;
            }
            else if (id.equals("END")) {
                end = true;
            }
        }
    }
    
    private void loadRectangle(String[] tokens, boolean erase) 
    {
        
    }
    
    private enum LoadState 
    {
        LOAD_FRAME,
        FIND_FRAME
    }
}
