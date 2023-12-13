package View;

import java.util.List;

public interface Iview {
    void drawMenu();

    void drawGame();

    void drawSnake(List<Integer> x, List<Integer> y, int c);

    void drawBadFood(int a, int b);

    void drawGoodFood(int a, int b);

    void setMessageToBePrinted(int a);
    boolean isTimeSmallerAsDuration();
    void  drawMessage();
    void drawGameOver();
}
