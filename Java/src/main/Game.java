package main;

import java.awt.Color;
import state.GameState;
import state.MainMenuState;
import state.PlayingState;
import uni.Canvas;
import world.animation.Animation;
/**
 * The main class for the game
 * @author mhops
 */
public class Game 
{
    public static final int WIDTH = 1300;
    public static final int HEIGHT = 800;
    
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
        canvas.addMouseListener(new Mouse(states));
        
        isRunning = true;
    }
    
    /**
     * Runs the main game loop until the game is over
     */
    public void run()
    {
        while (isRunning) {
            GameState state = states.peekState();
            clearCanvas();
            state.update();
            state.draw(canvas);
            canvas.wait(16);
        }
        System.out.println("Game ended");
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
