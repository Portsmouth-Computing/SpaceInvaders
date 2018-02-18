/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.concurrent.TimeUnit;

/**
 * A class for measuring time
 * @author mhops
 */
public class Timer 
{
    long startTime;
    
    public Timer() 
    {
        reset();
    }
    
    public long getTimeAsNanoseconds()
    {
        return now() - startTime;
    }
    
    public double getTimeAsSeconds() 
    {
        return TimeUnit.MILLISECONDS.convert(getTimeAsNanoseconds(), TimeUnit.NANOSECONDS) / 1000.0;
    }
    
    public void reset()
    {
        System.out.println("Reset");
        startTime = now();
    }
    
    private long now()
    {
        return System.nanoTime();
    }
}
