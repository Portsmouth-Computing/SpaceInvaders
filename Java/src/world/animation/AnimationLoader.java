package world.animation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Helper class to load an animation
 * @author mhops
 */
public class AnimationLoader 
{
    ArrayList<Frame> frames;
    Frame currentFrame;
    boolean loadingFrame;
    boolean end;
    
    /**
     * Constructs the class
     */
    public AnimationLoader()
    {
        frames = new ArrayList<>();
        currentFrame = null;
        loadingFrame = false;
        end = false;
    }
    
    /**
     * Loads an animation
     * @param fileName The file which contains information about frames of an animation
     * @return ArrayList of frames of the animation
     */
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
    
    /**
     * Reads a line of the animation file and loads it into the right places
     * @param line A line of the animation file
     */
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
                    loadPolygon(tokens, false);
                    break;
                    
                case "ENDFRAME":
                    loadingFrame = false;
                    frames.add(currentFrame);
                    currentFrame = null;
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
    
    /**
     * Loads a rectangle
     * @param tokens numbers/ tokens of this line
     * @param erase If true, the canvas will have a rectangle erased
     */
    private void loadRectangle(String[] tokens, boolean erase) 
    {
        if (tokens.length < 5) {
            System.out.println("Unable to read rectangle not enough data!");
        }
        else {
            double x = Double.parseDouble(tokens[1]);
            double y = Double.parseDouble(tokens[2]);
            double w = Double.parseDouble(tokens[3]);
            double h = Double.parseDouble(tokens[4]);
            currentFrame.addShape(new Shapes.Rectangle(x, y, w, h, erase));
        }
    }
    
    private void loadPolygon(String[] tokens, boolean erase) 
    {
        if (tokens.length % 2 == 0) {
            System.out.println("Unable to load polygon, mismatch of X and Y data");
        }
        else {
            int numPoints = (tokens.length - 1) / 2;
            double[] xPoints = new double[numPoints];
            double[] yPoints = new double[numPoints];
            for (int i = 1, point = 0; i < tokens.length; i += 2, point++) {
                xPoints[point] = Double.parseDouble(tokens[i]);
                yPoints[point] = Double.parseDouble(tokens[i + 1]);
            }
            currentFrame.addShape(new Shapes.Polygon(xPoints, yPoints, erase));
        }
    }
}
