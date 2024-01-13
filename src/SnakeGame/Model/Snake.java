package SnakeGame.Model;

import java.util.ArrayList;

/**
 * Snake class is used to create a snake object that will be used in the game, with the snake's coordinates and the direction it is moving in.
 */
public class Snake {
    /**
     * it uses two array lists to store the x and y coordinates of the snake
     */
    private ArrayList<Integer> xCoordinates = new ArrayList<>(), yCoordinates = new ArrayList<>();
    /**
     * move is used to store the direction the snake is moving in
     */
    private Direction direction;


    /**
     * This constructor is used to create a snake object with the initial x and y coordinates and the initial direction
     * @param initialX
     * @param initialY
     * @param initialDirection
     */
    public Snake(int initialX, int initialY, Direction initialDirection) {
        xCoordinates.add(initialX);
        xCoordinates.add(initialX-1);
        yCoordinates.add(initialY);
        yCoordinates.add(initialY-1);
        direction = initialDirection;
    }

    /**
     * This method is used to get the x coordinates of the snake
     * @return xCoordinates
     */
    public ArrayList<Integer> getxCoordinates(){
        return xCoordinates;
    }
    /** This method is used to get the y coordinates of the snake
     * @return yCoordinates
     */
    public ArrayList<Integer>getyCoordinates(){
        return yCoordinates;
    }
    /** 
     * Setter for direction
     * @param direction
     */
    public void setDirection(Direction direction){
        this.direction=direction;
    }
    /** 
     * Getter for the  direction
     * @return direction
     */
    public Direction getDirection(){
        return direction;
    }

    /**
     * This method is used to increase the size of the snake
     */
    public void increaseSize(){
        getxCoordinates().add(0, getxCoordinates().get(0) + (getDirection() == Direction.RIGHT ? 1 :
                (getDirection() == Direction.LEFT ? -1 : 0)));
        getyCoordinates().add(0, getyCoordinates().get(0) + (getDirection() == Direction.DOWN ? 1 :
                (getDirection() == Direction.UP ? -1 : 0)));
    }
    public void decreaseSize(){
        getxCoordinates().remove(getxCoordinates().size() - 1);
        getyCoordinates().remove(getyCoordinates().size() - 1);
    }
    @Override
    public String toString() {
        String s="";
        for(int i=0;i<xCoordinates.size();i++){
            if(this.getDirection()==Direction.LEFT){
                if(i==0) s+="<";
                else s+="o";
            }
            else if(this.getDirection()==Direction.RIGHT){
                if(i==0)s+=">";
                else s="o"+s;
            }
            else if(this.getDirection()==Direction.UP){
                if(i==0) s+="\n"+"^"+"\n";
                else s+="o"+" "+"\n";
            }
            else if(this.getDirection()==Direction.DOWN){
                if(i== xCoordinates.size())s+="\n"+"v"+"\n";
                else s+="o"+"\n";

               // s+="\n"+"v";
            }
                   
        }
        return s;
        
    }
}