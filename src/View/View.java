package View;

import Controller.Icontroller;
import processing.core.*;
import java.util.List;
/** The View contains codes on how to display My GameSnake
 *  It extends PApplet and implements the IView interface.
 */
public class View  extends PApplet implements Iview{
    /**
     * The controller for the game.
     */
    private Icontroller controller;
    /**
     * The number of blocks for the snake and food.
     */

    private final int block = 35;


    private PImage menu,playing, gameOver2, poison,wellDone,looser2,goodFood,neutralFood,winner,looser1;

    private int message,frame;
    private final int duration=100;

    private int r,g,b, yPosTop, yPosBottom;


    String topText = "Welcome to snakeGame";
    String bottomText = "press enter to start";

    /**
     * The main method that runs the PApplet.Main method to start the game.
     * @param
     */

    public void setController(Icontroller c){
        this.controller =c;
    }

   /*  public static void main(String[] args){
        PApplet.main(View.class);
    }
    */

    /**
     * The setup method is used to set the size of the game window.
     */
    public View(int a, int b){
        setSize(a,b);
    }

    /**
     * The setup method is used to set the size of the game window.
     * It is called once when the program starts.
     * It is used to define initial environment properties such as screen size
     *  and background color and to load media such as images and
     *  fonts as the program starts.
     */
    public void setup(){
        frameRate(7);
        textAlign(CENTER, CENTER);
        textSize(24);
        yPosTop = -50; // Start above the canvas
        yPosBottom = height + 50;
        looser2=loadImage("images/looser2.jpg");
        looser2.resize(120,120);
        looser1=loadImage("images/looser1.jpg");
        looser1.resize(120,120);
        gameOver2=loadImage("images/gameOver.jpg");
        gameOver2.resize(width,height);
        wellDone=loadImage("images/welldone.jpg");
        wellDone.resize(120, 120);
        goodFood = loadImage("images/good.jpg");
        goodFood.resize(block,block);
        poison=loadImage("images/poison.jpg");
        poison.resize(block,block);
        menu=loadImage("images/menu.jpg");
        playing=loadImage("images/playing.jpg");
        playing.resize(width,height);
        neutralFood=loadImage("images/neutral.jpg");
        neutralFood.resize(block,block);
        winner=loadImage("images/win.jpg");
        winner.resize(width,height);
        menu.resize(width,height);
    } 

    /**
     * The draw method is called directly after setup() and is used to
     * continuously execute the lines of code contained inside its block
     * until the program is stopped or noLoop() is called.
     * Each statement is executed in sequence and after the last line is read,
     * the first line is executed again.
     * @param
     */
 
    public void draw(){
        if(controller !=null) controller.nextFrame();
    }
    public void keyPressed() {
        if (keyCode==ENTER) controller.userInput(0);

        if (keyCode == UP) {
            controller.userInput(3); // For UP arrow key
        } else if (keyCode == DOWN) {
            controller.userInput(4); // For DOWN arrow key
        } else if (keyCode == LEFT) {
            controller.userInput(1); // For LEFT arrow key
        } else if (keyCode == RIGHT) {
            controller.userInput(2); // For RIGHT arrow key
        }
    }

    /**
     * The method that draws the title screen of the game.
     * It displays the title and instructions on how to start the game.
     */
    public void drawMenu(){
        frameRate(30);
        if(yPosTop < height / 2 - 20) background(0);
        else background(menu);
        // Move text towards the middle until they meet
        if (yPosTop < height / 2 - 20) {
            yPosTop += 1;
            yPosBottom -= 1;
        }


        // Display text at updated positions
        fill(255);
        text(topText, width / 2, yPosTop);
        text(bottomText, width / 2, yPosBottom);
    }
    /**
     * The method that resets the title screen of the game.
     * It resets the title and instructions on how to start the game.
     */
     public void resetMenu(){
         yPosTop = -50; // Start above the canvas
         yPosBottom = height + 50;
     }
    /**
     * The method that draws the snake on the screen.
     */
    public void drawGame(){
        frameRate(7);
        background(playing);
    }
    /**
     * The method that draws the snake on the screen.
     * @param x the x coordinates of the snake
     * @param y the y coordinates of the snake
     */
    public void drawSnake(List<Integer> x, List<Integer> y,int c, int q){
         for(int i=0; i<x.size(); i++){
             if(i==0) fill(255,22,100) ;
              else fill(0);

             super.rect(x.get(i)*block,y.get(i)*block, block,block);
         }
         textAlign(RIGHT);
         textSize(30);
         text("Time: "+q,10,10, width -130, 50);
         text("Score: " +c,10,10, width -20, 50);

    }
    /**
     * The method that draws the food on the screen.
     * @param foodX the x coordinate of the food
     * @param foodY the y coordinate of the food
     */
    public void drawBadFood(int foodX, int foodY) {
        super.image(poison,foodX*block,foodY*block);
        //super.rect(foodX * block, foodY * block, block, block);
    }
    /**
     * The method that draws the food on the screen.
     * @param foodX the x coordinate of the food
     * @param foodY the y coordinate of the food
     */
    public void drawNeutralFood(int foodX, int foodY){
        super.image(neutralFood,foodX*block,foodY*block);
    }
    /**
     * The method that draws the food on the screen.
     * @param foodX the x coordinate of the food
     * @param foodY the y coordinate of the food
     */
    public void drawMessage() {
            switch (message) {
                case 1:
                    super.image(wellDone, 300, block);
                    super.image(wellDone, 300, block);
                    fill(0);
                    super.text("NICE TRY", 600, 70);
                    break;
                case 2:
                    super.image(looser2,300,block);
                    super.image(looser2,300,block);
                    fill(0);
                    super.text("LOOSER",600,70);
                    break;
                case 3:
                    super.image(looser1,300,block);
                    super.image(looser1,300,block);
                    fill(0);
                    super.text("I Got you",600,70);
                    break;
            }
        }


    public void setMessageToBePrinted(int a){
         message=a;
    }

    public void drawGoodFood(int foodX, int foodY) {
        super.image(goodFood,foodX*block,foodY*block);
    }
    public void drawGameOver(){
        background(gameOver2);
    }
    public void drawWinner(){ background(winner);}
}
