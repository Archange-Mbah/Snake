
import processing.core.PApplet;
import Model.*;
import Controller.*;
import View.*;
public  final class Main {
    public static void main(String[] args) {

        final int GAME_SIZE = 700;
        var view = new View(GAME_SIZE,GAME_SIZE);
        var model = new SnakeModel();
        var controller = new Controller();
        controller.setModel(model);
        controller.setView(view);
        view.setController(controller);


        PApplet.runSketch(new String[]{"SnakeGame"}, view);
    }
}