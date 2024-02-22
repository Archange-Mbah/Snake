package SnakeGame;

import processing.core.PApplet;
import SnakeGame.Model.*;
import SnakeGame.Controller.*;
import SnakeGame.View.*;
/**
 * The Main class is used to run the Snake game.
 * It creates the view, model, and controller objects, and runs the game.
 */
public  final class Main {
    /**
     * The main method is used to run the Snake game.
     */
    public static void main(String[] args) {
        /**
         *  SIZE1 is the width of the game window.
         * SIZE2 is the height of the game window.
         */
        final int SIZE1 = 750;
        final int SIZE2=600;
        /**
         * The view, model, and controller objects are created.
         */
        var view = new View(SIZE1,SIZE2);
        var model = new SnakeModel();
        var controller = new Controller();
        controller.setModel(model);
        controller.setView(view);
        view.setController(controller);
         /**
          * The view is run.
          */

        PApplet.runSketch(new String[]{"SnakeGame"}, view);
    }
}