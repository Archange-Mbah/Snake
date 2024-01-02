package View;

import java.util.List;

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
