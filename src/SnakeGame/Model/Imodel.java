package SnakeGame.Model;

/**
 * Imodel is an interface that contains the methods that will be used   by the controller
 */
 
 
public interface Imodel {
    Snake getSnake();
    Food getGoodFood();
    Food getBadFood();
    GameState getState();
    void play();
    void setState(GameState state);
    void setDirection(Direction direction);
    int getScore();

    Direction getDirection();

    int getMessageNumber();
    int getTime();
    Food getNeutralFood();
    void reset();
}
