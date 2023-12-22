package Controller;

import Model.Imodel;
import Model.GameState;
import Model.Direction;
import View.Iview;

public class Controller implements Icontroller {

    private Iview view;

    private Imodel  snakeGame;

    private int duration=120;


    public void setView(Iview v) {
        this.view = v;
    }

    public void setModel(Imodel  s) {
        this.snakeGame = s;
    }

    public void startGame() {
        if (snakeGame.getState() == GameState.MENU) {
            snakeGame.setState(GameState.PLAYING);
        }
    }

    public void nextFrame() {
        if (snakeGame.getState() == GameState.MENU) {
            view.drawMenu();
        }
        else if (snakeGame.getState() == GameState.PLAYING) {
            view.drawGame();
            snakeGame.play();
            view.drawMessage();
            view.drawMessage2();
            view.drawMessage3();
            view.setMessageToBePrinted(snakeGame.getMessageNumber());
            view.drawSnake(snakeGame.getSnake().getxCoordinates(),snakeGame.getSnake().getyCoordinates(),snakeGame.getScore(),snakeGame.getTime());
            drawFoods();
        }
        else if(snakeGame.getState()==GameState.WIN){
          view.drawWinner();
        }
        else{
            view.drawGameOver();
        }
    }

    private void drawFoods(){
        view.drawBadFood(snakeGame.getBadFood().getX(),snakeGame.getBadFood().getY());
        view.drawGoodFood(snakeGame.getGoodFood().getX(),snakeGame.getGoodFood().getY());
        view.drawNeutralFood(snakeGame.getNeutralFood().getX(),snakeGame.getNeutralFood().getY());
    }

    public void userInput(int input) {
        if(snakeGame.getState()==GameState.MENU && input==0){
            snakeGame.setState(GameState.PLAYING);
        }
       if(input==1 && snakeGame.getDirection()!=Direction.RIGHT )
           snakeGame.setDirection(Direction.LEFT);
        if(input==2&& snakeGame.getDirection()!=Direction.LEFT)
            snakeGame.setDirection(Direction.RIGHT);
        if(input==3 && snakeGame.getDirection()!=Direction.DOWN )
             snakeGame.setDirection(Direction.UP);
        if(input ==4 && snakeGame.getDirection()!=Direction.UP)
            snakeGame.setDirection(Direction.DOWN);
        }

}

