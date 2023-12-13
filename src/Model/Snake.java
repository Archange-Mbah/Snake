package Model;

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

     public static void main(String args[]){
         Snake s= new Snake(3,4,Direction.DOWN);
         System.out.println(s.toString());

     }
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

    @Override
    public String toString() {
        String s="";
        for(int i=0;i<xCoordinates.size();i++){
            if(this.getDirection()==Direction.LEFT){
                if(i==0){
                    s+="<";
                }
                else{
                    s+="o";
                }
            }
            else if(this.getDirection()==Direction.RIGHT){
                if(i==0){
                    s+=">";
                }
                else{
                    s="o"+s;
                }
            }
            else if(this.getDirection()==Direction.UP){
                if(i==0){
                    s+="^";
                }
                else{
                    s+="o"+" "+"\n";
                }
            }
            else if(this.getDirection()==Direction.DOWN){
                if(i==0){
                    s+="v";
                }
                else{
                    s+="o";
                }
                s+="\n"+"v";
            }
                   
        }
        return s;
        /*StringBuilder snakeStringBuilder = new StringBuilder(); //create a string builder object
        for (int i = 0; i < xCoordinates.size(); i++) {
            if (i == 0 && direction == Direction.RIGHT) {
                // Head of the snake
                snakeStringBuilder.append("> ");
            } else if (i == 0 && direction == Direction.LEFT) {
                // Head of the snake
                snakeStringBuilder.append("< ");
            } else if (i == 0 && direction == Direction.UP) {
                // Head of the snake
                snakeStringBuilder.append("^ ");
            } else if (i == 0 && direction == Direction.DOWN) {
                // Head of the snake
                snakeStringBuilder.append("v ");
            } else {
                // Body segments
                snakeStringBuilder.append("o");
            }
        }
        return   snakeStringBuilder.toString().trim() +" at ( "+xCoordinates.get(0)+","+yCoordinates.get(0)+")";*/
    }
}