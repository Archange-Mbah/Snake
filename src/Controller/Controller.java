package Controller;

import Model.Imodel;
import Model.GameState;
import Model.Direction;
import View.Iview;

/**The Controller class implements the Icontroller interface and controls the flow of the Snake game.
*It controlls the flow of the game by processing user input, updating the model, and updating the view. 
*/
public class Controller implements Icontroller {

    /**
     * This method is used to set the view of the game
     * @param view is the view of the game
     */
    private Iview view;

    /**
     * This method is used to set the model of the game
     * @param snake is the model of the game
     */
    private Imodel  snakeGame;


    /**
     * This method is used to set the view of the game
     * @param view is the view of the game
     */
    public void setView(Iview view) {
        this.view = view;
    }
    /**
     * This method is used to set the model of the game
     * @param snake is the model of the game
     */
    public void setModel(Imodel  snake) {
        this.snakeGame = snake;
    }


    /**
     * This method is used to update the view of the game
     * It updates the view by drawing the menu, game, winner, and game over screen.
     * It also draws the snake and food.
     * It also draws the message of the game.
     */
       public void nextFrame() {
        var message=snakeGame.getMessageNumber();
        var xCoordinates=snakeGame.getSnake().getxCoordinates();
        var yCoordinates=snakeGame.getSnake().getyCoordinates();
        var time=snakeGame.getTime();
        var score=snakeGame.getScore();
        switch (snakeGame.getState()) {
            case MENU:
                view.drawMenu();
                break;
            case PLAYING:
                view.drawGame();
                snakeGame.play();
                view.drawMessage();
                view.setMessageToBePrinted(message);
                view.drawSnake(xCoordinates,yCoordinates,score,time);
                drawFoods();
                break;
            case WIN:
                view.drawWinner();
                break;
            case GAMEOVER:
                view.drawGameOver();
                break;
        }
    }
    /**
     * This method is used to draw the different types of food on the screen.
     * it obtains the x and y coordinates of the food from the model and passes them to the view.
     */
    private void drawFoods(){
        var badFoodX=snakeGame.getBadFood().getX();
        var badFoodY=snakeGame.getBadFood().getY();
        var goodFoodX=snakeGame.getGoodFood().getX();
        var goodFoodY=snakeGame.getGoodFood().getY();
        var neutralFoodX=snakeGame.getNeutralFood().getX();
        var neutralFoodY=snakeGame.getNeutralFood().getY();

        view.drawBadFood(badFoodX,badFoodY);
        view.drawGoodFood(goodFoodX,goodFoodY);
        view.drawNeutralFood(neutralFoodX,neutralFoodY);
    }

    /**
     * This method is used to process the user input.
     * It processes the user input by changing the direction of the snake.
     * It also changes the state of the game from menu to playing and from win or game over to menu.
     * @param input is the user input
     */ 
    public void userInput(int input) {
        if(snakeGame.getState()==GameState.MENU && input==0){
            snakeGame.setState(GameState.PLAYING);
        }
        else if((snakeGame.getState()==GameState.WIN || snakeGame.getState()==GameState.GAMEOVER) && input==0 ){
            snakeGame.reset();
            view.resetMenu();
        }
       else if(input==1 && snakeGame.getDirection()!=Direction.RIGHT )
           snakeGame.setDirection(Direction.LEFT);
        else if(input==2&& snakeGame.getDirection()!=Direction.LEFT)
            snakeGame.setDirection(Direction.RIGHT);
        else if(input==3 && snakeGame.getDirection()!=Direction.DOWN )
             snakeGame.setDirection(Direction.UP);
        else if(input ==4 && snakeGame.getDirection()!=Direction.UP)
            snakeGame.setDirection(Direction.DOWN);
        }

}

