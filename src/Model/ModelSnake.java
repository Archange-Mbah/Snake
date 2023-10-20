package Model;

import java.util.ArrayList;
import java.util.Random;
public class ModelSnake {

public ModelSnake(){
     xCoordinates.add(0);
     yCoordinates.add(5);
    foodx=rand.nextInt(0,w);
    foody=rand.nextInt(0,w);
    badFoodx=rand.nextInt(0,w/2);
    badFoody=rand.nextInt(0,h/2);
}


    /**
     * It uses the ArrayList class from the java.util package to store the x and y coordinates of the snake
     */
    private ArrayList<Integer>xCoordinates=new ArrayList<>(),yCoordinates=new ArrayList<>();

    int w=20;
    int h=20;
    Random rand= new Random();
    private int move=rand.nextInt(0,5);


private int foodx;  // the x coordinate of the food
private int foody;  // the y coordinate of the food
public int score; // the player's score
private int badFoodx;  // the coordinate of the bad food
private int badFoody; // the coordinate of the good food
public boolean gameStart=true;  // the state of the game

    int[] movementalongtheXaxis = {0, 0, 1, -1}; // Movement

    int[] movementalong_Yaxis={1, -1, 0, 0};// Movement

    private ArrayList<Integer> getxCoordinates(){
        return xCoordinates;
    }
    private ArrayList<Integer>getyCoordinates(){
        return yCoordinates;
    }

    public int getFoodx(){
        return foodx;
    }

    public int getFoody(){
        return foody;
    }
    public int getBadFoodx(){
        return badFoodx;
    }
    public int getBadFoody(){
        return badFoody;
    }

    public int getMove(){
        return this.move;
    }
    public void setFoody(int food){
        foody=food;
    }
    public void setFoodx(int food){
        foodx=food;
    }

    public void setBadFoodx(int food){
        badFoodx=food;
    }
    public void setBadFoody(int food){
        badFoody=food;
    }
    public void setMove(int move){
        this.move=move;
    }


    public void Game(){

    }


}
