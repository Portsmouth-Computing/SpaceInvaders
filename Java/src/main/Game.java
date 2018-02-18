/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import state.GameState;
import state.PlayingState;
import uni.Canvas;
/**
 * The main class for the game
 * @author mhops
 */
public class Game 
{
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    
    private StateManager states;
    private Canvas canvas;
    private boolean isRunning;
    
    /**
     * Construct the game class
     */
    public Game() 
    {
        states = new StateManager(new PlayingState(this));
        canvas = new Canvas("Space Invaders", WIDTH, HEIGHT, Color.BLACK);
        canvas.addKeyListener(new Keyboard(states));
        
        isRunning = true;
    }
    
    /**
     * Runs the main game loop
     */
    public void run()
    {
        int ticks = 0;
        while (isRunning) {
            
            GameState state = states.peekState();
            
            clearCanvas();
            
            state.update();
            state.draw(canvas);
            
            ticks++;
            canvas.wait(16);
        }
    }
    
    /**
     * Clears the canvas of everything currently drawn onto it
     */
    public void clearCanvas() 
    {
        canvas.eraseRectangle(0, 0, WIDTH, HEIGHT);
    }
    
    /**
     * Stops the game running
     */
    public void exit() 
    {
        isRunning = false;
    }
    
    public static void main(String... args) 
    {
        new Game().run();
    }
}
