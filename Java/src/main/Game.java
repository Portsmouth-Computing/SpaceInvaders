/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

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
    
    public Game() 
    {
        states = new StateManager(new PlayingState(this));
        canvas = new Canvas("Space Invaders", WIDTH, HEIGHT);
        canvas.addKeyListener(new Keyboard(states));
    }
    
    public void run()
    {
        
    }
    
    
    
    public static void main(String... args) 
    {
        new Game().run();
    }
}
