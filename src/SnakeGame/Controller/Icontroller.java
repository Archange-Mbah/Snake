package SnakeGame.Controller;

/**
 * The Icontroller interface is used to control the flow of the Snake game.
 * It is used to process user input, update the model, and update the view.
 * The methods in this interface are implemented in the Controller class and used in the View class.
 */
public interface Icontroller {

    void nextFrame();
    void userInput(int a);
}
