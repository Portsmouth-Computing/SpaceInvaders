package state;

import gui.Button;
import gui.ButtonCallback;
import java.awt.Color;
import java.awt.Font;
import main.Game;
import uni.Canvas;
import util.Vector2D;

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
                game.getStates().pushState(new PlayingState(game));
            }
        });
    }

    @Override
    public void handleMouseClick(int button, Vector2D location) 
    {
        System.out.println(button);
        this.button.onClick(location);
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
