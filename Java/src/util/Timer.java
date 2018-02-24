package util;

import java.util.concurrent.TimeUnit;

/**
 * A class for measuring time
 * @author mhops
 */
public class Timer 
{
    private long startTime;
    
    public Timer() 
    {
        reset();
    }
    
    /**
     * Gets the elapsed time since last reset in nanoseconds
     * @return Elapsed time since last reset in nanoseconds
     */
    public long getTimeAsNanoseconds()
    {
        return now() - startTime;
    }
    
    /**
     * Gets the elapsed time since last reset in seconds
     * @return Elapsed time since last reset in seconds
     */
    public double getTimeAsSeconds() 
    {
        return TimeUnit.MILLISECONDS.convert(getTimeAsNanoseconds(), TimeUnit.NANOSECONDS) / 1000.0;
    }
    
    /**
     * Resets the timer
     */
    public void reset()
    {
        startTime = now();
    }
    
    /**
     * Gets the current system time
     * @return current system time
     */
    private long now()
    {
        return System.nanoTime();
    }
}
