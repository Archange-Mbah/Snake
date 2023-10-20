package Model;

import java.util.ArrayList;

public class Snake {
    private ArrayList<Integer> xCoordinates = new ArrayList<>();
    private ArrayList<Integer> yCoordinates = new ArrayList<>();
    private int move;

    public Snake(int initialX, int initialY, int initialMove) {
        xCoordinates.add(initialX);
        yCoordinates.add(initialY);
        move = initialMove;
    }

    public ArrayList<Integer> getxCoordinates(){
        return xCoordinates;
    }
    public ArrayList<Integer>getyCoordinates(){
        return yCoordinates;
    }
    public void setMove(int move){
        this.move=move;
    }
    public int  getMove(){
        return this.move;
    }
}