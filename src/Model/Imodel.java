package Model;

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
}
