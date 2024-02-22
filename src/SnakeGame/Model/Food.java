package SnakeGame.Model;

/**
 * Food class is used to create a food object that will be used in the game, with the food's coordinates and whether the food is good or bad.
 */

public class Food {
    /**
     * x and y are the coordinates of the food
     */
    private int x,y;


    /**
     * This constructor is used to create a food object with the initial x and y coordinates and whether the food is good or bad
     * @param x is the x coordinate of the food
     * @param y is the y coordinate of the food

     */
    public Food(int x, int y){
        this.x=x;
        this.y=y;
    }
     /**
      * Setter for x
      * @param x to set the x coordinate of the food
      */
    public void setX(int x){
        this.x=x;
    }
     /**
      * Setter for y
      * @param y to set the y coordinate of the food
      */
    public void setY(int y){
        this.y=y;
    }
     /**
      * Getter for x
      * @return x to get the x coordinate of the food
      */
    public int getX(){
        return x;
    }
     /**
      * Getter for y
      * @return y
      */
    public int getY(){
        return y;
    }


     /**
      * toString method
      * @return the food is at position (x y)
      */    
    @Override
    public String toString(){
        return "the food is at position ("+ getX()+" " + getY()+")";
    }
}
