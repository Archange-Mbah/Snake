package SnakeGame.View;


import SnakeGame.Controller.Icontroller;
import processing.core.*;
import java.util.List;
/** The View contains codes on how to display My GameSnake
 *  It extends PApplet and implements the IView interface.
 */
public class View  extends PApplet implements Iview {
    /**
     * The controller for the game.
     */
    private Icontroller controller;
    /**
     * The number of blocks for the snake and food.
     */

    private final int block = 30;


    private PImage menu,playing, gameOver, poison,wellDone,looser2,goodFood,neutralFood,winner,looser1;

    private int message;


    private int  yPosTop, yPosBottom;


    String topText = "Welcome to snakeGame";
    String bottomText = "press enter to start";
    String important= "IMPORTANT: you lose if you eat the "+'\n'+
            " poison at the begining of the game";

    /**
     * The main method that runs the PApplet.Main method to start the game.
     * @param c is the controller
     */

    public void setController(Icontroller c){
        this.controller =c;
    }


    /**
     * The setup method is used to set the size of the game window.
     * @param a is the width of the window
     * @param b is the height of the window 
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
        looser2=loadImage("looser2.jpg");
        looser2.resize(120,120);
        looser1=loadImage("looser1.jpg");
        looser1.resize(120,120);
        gameOver=loadImage("gameOver.jpg");
        gameOver.resize(width,height);
        wellDone=loadImage("welldone.jpg");
        wellDone.resize(120, 120);
        goodFood = loadImage("good.jpg");
        goodFood.resize(block,block);
        poison=loadImage("poison.jpg");
        poison.resize(block,block);
        menu=loadImage("menu.jpg");
        playing=loadImage("background.jpg");
        playing.resize(width,height);
        neutralFood=loadImage("neutral.jpg");
        neutralFood.resize(block,block);
        winner=loadImage("win.jpg");
        winner.resize(width,height);
        menu.resize(width,height);
    } 

    /**
     * The draw method is called directly after setup() and is used to
     * continuously execute the lines of code contained inside its block
     * until the program is stopped or noLoop() is called.
     * Each statement is executed in sequence and after the last line is read,
     * the first line is executed again.
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
        fill(51,255,255);
        text(topText, 400, yPosTop);
        text(bottomText, 400, yPosBottom);
        fill(255,0,0);
        text(important, 400,yPosBottom+50);
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
    public void drawSnake(List<Integer> x, List<Integer> y,int c, int q) {
        for (int i = 0; i < x.size(); i++) {
            // stroke(0);// border color
            if (i == 0)
                fill(255, 0, 0);
            else {
                stroke(0);
                fill(1, 50, 36);
            }


            super.rect(x.get(i) * block, y.get(i) * block, block, block);
        }
        textAlign(RIGHT);



            textSize(30);
            text("Time: " + q, 10, 10, width - 130, 50);
            text("Score: " + c, 10, 10, width - 20, 50);



        }

    /**
     * The method that draws the food on the screen.
     * @param foodX the x coordinate of the food
     * @param foodY the y coordinate of the food
     */
    public void drawBadFood(int foodX, int foodY) {
        super.image(poison,foodX*block,foodY*block);
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
     */
    public void drawMessage() {
            switch (message) {
                case 1:
                    super.image(wellDone, 300, block);
                    super.image(wellDone, 300, block);
                    fill(255,0,0);
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
      /**
       * it is used to set the message to be printed
       */
    public void setMessageToBePrinted(int a){
         message=a;
    }

    /**
     * The method that draws the food on the screen.
     * @param foodX the x coordinate of the food
     * @param foodY the y coordinate of the food
     */
    public void drawGoodFood(int foodX, int foodY) {
        super.image(goodFood,foodX*block,foodY*block);
    }
    /**
     * The method that draws the image of the game over screen.
     */
    public void drawGameOver(){
        background(gameOver);
        
         textSize(30);
         fill(255);
        text("Press Enter ",(width/2)-300,height-200, width/2, 50);
    }
    /**
     * The method that draws the image of the winner screen.
     */
    public void drawWinner(){
        background(winner);
        textSize(30);
        fill(255,0,0);
        text("Press Enter  to play again",(width/2)-300,10, width/2, 50);
    }
}
