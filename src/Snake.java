
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victor
 */
public class Snake {
    
    private ArrayList<Node> body;
    private Direction direction;
    
    public Snake() {
        body = new ArrayList<Node>();
        body.add(new Node(Board.NUM_ROWS/2, Board.NUM_COLS/2));
        body.add(new Node(Board.NUM_ROWS/2, Board.NUM_COLS/2 - 1));
        body.add(new Node(Board.NUM_ROWS/2, Board.NUM_COLS/2 - 2));
        body.add(new Node(Board.NUM_ROWS/2, Board.NUM_COLS/2 - 3));
        direction = Direction.RIGHT;
    }
    
   
    public List<Node> getBody() {
        return body;
    }
    
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    public Direction getDirection(){
        return direction;
    }
    
    
    public void paint(Graphics g, int width, int height) {
        boolean firstNode = true;
        Color color;
        for (Node node: body) {
            if (firstNode) {
                color = Color.red;
                firstNode = false;
            } else {
                color = Color.yellow;
            }
            Util.drawSquare(g, node.row, node.col, color, width, height);
        }
    }
    
    public void move() {
        grow();
        body.remove(body.size()-1);
    }
    
    public void grow() {
        switch (direction) {
            case UP: body.add(0, new Node(body.get(0).row - 1, body.get(0).col));
                     break;
            case DOWN: body.add(0, new Node(body.get(0).row + 1, body.get(0).col));
                     break;
            case LEFT: body.add(0, new Node(body.get(0).row , body.get(0).col - 1));
                     break;
            case RIGHT: body.add(0, new Node(body.get(0).row , body.get(0).col + 1));
                     break;
        }
    }
    
    public boolean colide() {
        int row = body.get(0).row;
        int col = body.get(0).col;
        switch (direction) {
            case UP: if (row - 1 < 0)
                        return true;
                     break;
            case DOWN: if (row + 1 >= Board.NUM_ROWS)
                        return true;
                     break;
            case LEFT: if (col - 1 < 0)
                        return true;
                     break;
            case RIGHT:if (col + 1 >= Board.NUM_COLS)
                        return true;
                     break;
        }
        for (int i = 1; i< body.size(); i++) {
            if (body.get(i).row == row && body.get(i).col == col) {
                return  true;
            }
        }
        return false;
    }
    
    public boolean eats(Food food) {
        if (food.row == body.get(0).row && food.col == body.get(0).col) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean canMove(Direction newDirection){

        
        return true;
    }
    
}
