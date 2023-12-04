package View;

import Controller.Icontroller;
import processing.core.PApplet;
import processing.core.PImage;
import controlP5.*;

import java.util.List;

public class View  extends PApplet implements Iview{
    private Icontroller controller;

    private final int block = 35;

    PImage menu;
    PImage playing;
    PImage gameOVer;
    PImage badFood;
    int r,g,b;


    PImage goodFood;

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
        frameRate(6);
        goodFood = loadImage("apfel.jpg");
        goodFood.resize(block,block);
        badFood=loadImage("mushroom.jpg");
        badFood.resize(block,block);
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
        background(menu);
        super.textAlign(CENTER, CENTER);
        super.noStroke();
        super.textSize(40);
        super.text("**Welcom to Snake Game** ", width / 2 - 50, height / 4 - 10);
        super.textSize(30);
        super.fill(255);
        super.text("Press Enter key to start", width / 2 - 70, height / 2 - 80);
    }

    public void drawGame(){
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
        super.image(badFood,foodX*block,foodY*block);
        //super.rect(foodX * block, foodY * block, block, block);
    }
    public void drawGoodFood(int foodX, int foodY) {
        super.image(goodFood,foodX*block,foodY*block);
    }

}
