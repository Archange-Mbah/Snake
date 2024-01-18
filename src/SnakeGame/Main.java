package SnakeGame;

import processing.core.PApplet;
import SnakeGame.Model.*;
import SnakeGame.Controller.*;
import SnakeGame.View.*;
public  final class Main {
    public static void main(String[] args) {

        final int SIZE1 = 750;
        final int SIZE2=600;
        var view = new View(SIZE1,SIZE2);
        var model = new SnakeModel();
        var controller = new Controller();
        controller.setModel(model);
        controller.setView(view);
        view.setController(controller);


        PApplet.runSketch(new String[]{"SnakeGame"}, view);
    }
}