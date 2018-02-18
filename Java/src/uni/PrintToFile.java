package uni;

import java.io.*;

/**
 * Class which can be used to print strings to files
 * @author AncientC
 */
public class PrintToFile 
{
    /**
     * Method to write a string to a new file
     * @param filename The name of the file to create and write to
     * @param text The text to be written to the file
     */
    public void createNewFile(String filename, String text)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            
            writer.write(text);
            
            writer.close();
            
        }
        catch(IOException e)
        {
            System.out.println("Error, file not written " + e.getMessage());                    
        }
    }
    
    /**
     * Method to write a string to an existing file
     * @param filename The name of the existing file to write to
     * @param text The text to be written to the file
     */
    public void addToFile(String filename, String text)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            
            writer.append("\n");
            writer.append(text);
            
            writer.close();
            
        }
        catch(IOException e)
        {
            System.out.println("Error, file not written " + e.getMessage());                    
        }
    }
    
}
