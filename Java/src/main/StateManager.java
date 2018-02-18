/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Stack;
import state.GameState;
/**
 * Manages the states of the game
 * @author mhops
 */
public class StateManager 
{
    private Stack<GameState> states;
    
    /**
     * Constructs the state manager with an initial state
     * @param initalState The GameState to begin the game with
     */
    public StateManager(GameState initalState) 
    {
        states = new Stack<>();
        pushState(initalState);
    }
    
    /**
     * Get the current state
     * @return The current state at the top of the stack
     */
    public GameState peekState() 
    {
        return states.peek();
    }
    
    /**
     * Pushes a new state onto the stack stack
     * @param newState The new game state
     */
    public void pushState(GameState newState) 
    {
        states.add(newState);
    }
    
    /**
     * If there is a current state, then ends the current state
     */
    public void tryPopState() 
    {
        if (states.size() > 0) {
            states.pop();
        }
    }
}
