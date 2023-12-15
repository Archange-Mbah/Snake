package View;

import Controller.Icontroller;
import processing.core.*;




import java.util.List;

public class View  extends PApplet implements Iview{
    private Icontroller controller;

    private final int block = 35;


    private PImage menu;
    private PImage playing;
    private PImage gameOver2;
    private PImage poison ;
    private PImage wellDone;
    private int message,frame;
    private final int duration=100;
    private PImage looser2;
    private int r,g,b, yPosTop, yPosBottom;

    private PImage goodFood;
    String topText = "Welcome to snakeGame";
    String bottomText = "press enter to start";

    public void setController(Icontroller c){
        this.controller =c;
    }

    public static void main(String[] args){
        PApplet.main(View.class);
    }

    public View(int a, int b){
        setSize(a,b);
    }

    public void setup(){
        frameRate(7);
        textAlign(CENTER, CENTER);
        textSize(24);
        yPosTop = -50; // Start above the canvas
        yPosBottom = height + 50;
        looser2=loadImage("looser2.jpg");
        looser2.resize(120,120);
        gameOver2=loadImage("gameOver2.jpg");
        gameOver2.resize(width,height);
        wellDone=loadImage("welldone.jpg");
        wellDone.resize(120, 120);
        goodFood = loadImage("apfel.jpg");
        goodFood.resize(block,block);
        poison=loadImage("poison.jpg");
        poison.resize(block,block);
        menu=loadImage("menu.jpg");
        playing=loadImage("playing.jpg");
        playing.resize(width,height);
        menu.resize(width,height);
    }

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

    public void drawGame(){
        frameRate(7);
        background(playing);
    }
    public void drawSnake(List<Integer> x, List<Integer> y,int c){
         for(int i=0; i<x.size(); i++){
             if(i==0) fill(255,22,100) ;
              else fill(0);

             super.rect(x.get(i)*block,y.get(i)*block, block,block);
         }
         textAlign(RIGHT);
         textSize(30);
         text("Score: " +c,10,10, width -20, 50);
    }
    public void drawBadFood(int foodX, int foodY) {
        super.image(poison,foodX*block,foodY*block);
        //super.rect(foodX * block, foodY * block, block, block);
    }
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
            }
        }
    public void drawMessage2() {
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
        }
    }
    public void drawMessage3() {
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
}
