package Controller;

import Model.Direction;
import Model.GameState;
import Model.SnakeModel;
import View.Iview;

public class Controller implements Icontroller {

    private Iview view;
    private SnakeModel snakeGame;

    public void setView(Iview v) {
        this.view = v;
    }

    public void setModel(SnakeModel s) {
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
        } else if (snakeGame.getState() == GameState.PLAYING) {
            snakeGame.play();
            view.drawGame();
            view.drawSnake(snakeGame.getSnake().getxCoordinates(),snakeGame.getSnake().getyCoordinates(),snakeGame.getScore());
            view.drawBadFood(snakeGame.getBadFood().getX(),snakeGame.getBadFood().getY());
            view.drawGoodFood(snakeGame.getGoodFood().getX(),snakeGame.getGoodFood().getY());

        }
    }

    public void setDirection(int a) {

    }

    public void userInput(int input) {
        if(snakeGame.getState()==GameState.MENU && input==0){
            snakeGame.setState(GameState.PLAYING);
        }
       if(input==1 && snakeGame.getSnake().getDirection()!=Direction.RIGHT )
           snakeGame.setDirection(Direction.LEFT);
        if(input==2&& snakeGame.getSnake().getDirection()!=Direction.LEFT)
            snakeGame.setDirection(Direction.RIGHT);
        if(input==3 && snakeGame.getSnake().getDirection()!=Direction.DOWN )
             snakeGame.setDirection(Direction.UP);
        if(input ==4 && snakeGame.getSnake().getDirection()!=Direction.UP)
            snakeGame.setDirection(Direction.DOWN);
        }
    }

