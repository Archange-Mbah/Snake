
import processing.core.PApplet;
import Model.*;
import Controller.*;
import View.*;
public  final class Main {
    public static void main(String[] args) {

        final int SIZE1 = 875;
        final int SIZE2=700;
        var view = new View(SIZE1,SIZE2);
        var model = new SnakeModel();
        var controller = new Controller();
        controller.setModel(model);
        controller.setView(view);
        view.setController(controller);


        PApplet.runSketch(new String[]{"SnakeGame"}, view);
    }
}