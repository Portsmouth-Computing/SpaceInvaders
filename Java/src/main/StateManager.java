/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Stack;
import state.GameState;
/**
 *
 * @author mhops
 */
public class StateManager 
{
    private Stack<GameState> states;
    
    public StateManager(GameState initalState) 
    {
        pushState(initalState);
    }
    
    public GameState peekState() 
    {
        return states.peek();
    }
    
    public void pushState(GameState newState) 
    {
        states.add(newState);
    }
    
    public void tryPopState() 
    {
        if (states.size() > 0) {
            states.pop();
        }
    }
}
