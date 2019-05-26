
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victor
 */
public class SpecialFood extends Food {
    
    private int visibleMilliseconds;
    public static final int MAX_MILLISECONDS = 10000;
    public static final int MIN_MILLISECONDS = 3000;
    private Timer timer;
    
    public SpecialFood(Snake snake, Wall wall) {
        super(snake, wall);
        visibleMilliseconds = (int) (Math.random()*(MAX_MILLISECONDS - MIN_MILLISECONDS) 
                                                + MIN_MILLISECONDS);

    }
    
    public void paint(Graphics g, int width, int height) {
        Util.drawSquare(g, row, col, Color.magenta, width, height);
    }
    
    public int getVisibleMilliseconds(){
        System.out.println("SpecialFood.getVisibleMilliseconds()" + visibleMilliseconds);
        return visibleMilliseconds;
    }
    
}
