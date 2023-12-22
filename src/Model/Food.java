package Model;

/**
 * Food class is used to create a food object that will be used in the game, with the food's coordinates and whether the food is good or bad.
 */
public class Food {
    private int x,y;
    //private final boolean isGood; // true if the food is good, false if the food is bad

   /* public static void main(String args[]){
        Food f= new Food(2,3,true);
        System.out.println(f);
    }*/

    /**
     * This constructor is used to create a food object with the initial x and y coordinates and whether the food is good or bad
     * @param x
     * @param y

     */
    public Food(int x, int y){
        this.x=x;
        this.y=y;
    }
     /**
      * Setter for x
      * @param x
      */
    public void setX(int x){
        this.x=x;
    }
     /**
      * Setter for y
      * @param y
      */
    public void setY(int y){
        this.y=y;
    }
     /**
      * Getter for x
      * @return x
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
      * Getter for isGood
      * @return isGood
      */
    /*public boolean getIsGood(){
        return isGood;
    }*/
     /**
      * toString method
      * @return the food is at position (x y)
      */    
    @Override
    public String toString(){
        return "the food is at position ("+ getX()+" " + getY()+")";
    }
}
