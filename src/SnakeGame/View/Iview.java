package SnakeGame.View;

import java.util.List;
/**
 * This interface contains all necessary classes of a view to be usable by the controller.
 * Please note that your view class can contain additional methods, which will not accessible by the controller.
 */

public interface Iview {
    void drawMenu();
    void drawWinner();
    void drawGame();

    void drawSnake(List<Integer> x, List<Integer> y, int c,int q);

    void drawBadFood(int a, int b);

    void drawGoodFood(int a, int b);
    void drawNeutralFood(int a, int b);

    void setMessageToBePrinted(int a);

    void  drawMessage();
    void drawGameOver();
    void resetMenu();
    
}
