
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alex
 */
public class Wall {

    public List<Node> list;

    public Wall() {
        list = new ArrayList<Node>();
        createWalls();

    }

    public void drawWall(Graphics g, int height, int width) {
        for (Node node : list) {
            Util.drawSquare(g, node.row, node.col, Color.gray, width / Board.NUM_COLS, height / Board.NUM_ROWS);
        }
    }

    public boolean colideWalls(Snake snake, Direction direction) {
        int row = snake.getBody().get(0).row;
        int col = snake.getBody().get(0).col;

        switch (direction) {
            case UP:
                for (Node node : list) {
                    if (col == node.col && row - 1 == node.row) {
                        return true;
                    }
                }
                break;
            case DOWN:
                for (Node node : list) {
                    if (col == node.col && row + 1 == node.row) {
                        return true;
                    }
                }
                break;
            case LEFT:
                for (Node node : list) {
                    if (row == node.row && col - 1 == node.col) {
                        return true;
                    }
                }
                break;
            case RIGHT:
                for (Node node : list) {
                    if (row == node.row && col + 1 == node.col) {
                        return true;
                    }
                }
                break;
        }
        return false;
    }

    private void createWalls() {
        switch (Config.getInstance().getLevel()) {
            case 3:
                list.add(new Node(12, 5));
                list.add(new Node(12, 6));
                list.add(new Node(12, 7));
                list.add(new Node(12, 8));
                list.add(new Node(13, 5));
                list.add(new Node(13, 6));
                list.add(new Node(13, 7));
                list.add(new Node(13, 8));
                list.add(new Node(14, 5));
                list.add(new Node(14, 6));
                list.add(new Node(14, 7));
                list.add(new Node(14, 8));
                list.add(new Node(15, 5));
                list.add(new Node(15, 6));
                list.add(new Node(15, 7));
                list.add(new Node(15, 8));
            case 2:
                list.add(new Node(5, 32));
                list.add(new Node(5, 33));
                list.add(new Node(5, 34));
                list.add(new Node(5, 35));
                list.add(new Node(6, 32));
                list.add(new Node(6, 33));
                list.add(new Node(6, 34));
                list.add(new Node(6, 35));
                list.add(new Node(7, 32));
                list.add(new Node(7, 33));
                list.add(new Node(7, 34));
                list.add(new Node(7, 35));
                list.add(new Node(8, 32));
                list.add(new Node(8, 33));
                list.add(new Node(8, 34));
                list.add(new Node(8, 35));
            case 1:
                list.add(new Node(12, 32));
                list.add(new Node(12, 33));
                list.add(new Node(12, 34));
                list.add(new Node(12, 35));
                list.add(new Node(13, 32));
                list.add(new Node(13, 33));
                list.add(new Node(13, 34));
                list.add(new Node(13, 35));
                list.add(new Node(14, 32));
                list.add(new Node(14, 33));
                list.add(new Node(14, 34));
                list.add(new Node(14, 35));
                list.add(new Node(15, 32));
                list.add(new Node(15, 33));
                list.add(new Node(15, 34));
                list.add(new Node(15, 35));
            case 0:
                list.add(new Node(5, 5));
                list.add(new Node(5, 6));
                list.add(new Node(5, 7));
                list.add(new Node(5, 8));
                list.add(new Node(6, 5));
                list.add(new Node(6, 6));
                list.add(new Node(6, 7));
                list.add(new Node(6, 8));
                list.add(new Node(7, 5));
                list.add(new Node(7, 6));
                list.add(new Node(7, 7));
                list.add(new Node(7, 8));
                list.add(new Node(8, 5));
                list.add(new Node(8, 6));
                list.add(new Node(8, 7));
                list.add(new Node(8, 8));

                break;
        }
    }
}
