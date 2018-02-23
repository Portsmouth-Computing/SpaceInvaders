/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import gui.Button;
import gui.ButtonCallback;
import java.awt.Color;
import java.awt.Font;
import main.Game;
import uni.Canvas;
import world.Vector2D;

/**
 *
 * @author mhops
 */
public class MainMenuState extends GameState
{
    private Button button;
    
    public MainMenuState(Game game) 
    {
        super(game);
        button = new Button(200, 500, 200, 200, "hello there", new ButtonCallback() {
            @Override
            public void function()
            {
                System.out.println("Button pressed");
            }
        });
    }

    @Override
    public void handleMouseClick(int button, Vector2D location) 
    {
        System.out.println(button);
        this.button.update(location);
    }

    @Override
    public void handleKeyPress(int key) 
    {
        
    }

    @Override
    public void handleKeyUp(int key) 
    {
        
    }

    @Override
    public void update() 
    {
        
    }

    @Override
    public void draw(Canvas canvas) 
    {
        canvas.setForegroundColor(Color.WHITE);
        button.draw(canvas);
    }
    
}