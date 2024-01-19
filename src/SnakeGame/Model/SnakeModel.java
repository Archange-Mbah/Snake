package SnakeGame.Model;


/**
 * The java.util.Random class is used to generate a stream of pseudorandom numbers.
 */
import  java.util.Random;
import java.util.stream.IntStream;

/**
 * SnakeModel is used to create a  snake game Model
 */
public class SnakeModel implements Imodel{

     /**
      * snake is an object of the Snake class
      */
     private Snake snake;
    /**
     * goodfood is an object of the Food class
     * badFood is an object of the Food class
     * neutralFood is an object of the Food class
     */
    private final Food goodfood,badFood,neutralFood;

    /**
     * state is an object of the GameState class
     */
    private GameState state;
    /**
     * width and height are the width and height of the game
     * MAXIMUMSCORE is the maximum score that the player has to reach to win the game
     */
    private final int width=25,height=20,MAXIMUMSCORE=10;

    /**
     * messageNumber is used to store the number of the message that will be displayed in the game
     * score is used to store the score of the player
     * time is used to store the time left to the player
     */
    private int messageNumber=0,score=0,time=700;
    Random rand= new Random();


    /**
     * This constructor is used to create a SnakeModel object
     */
    public SnakeModel(){
        SnakeThread snakeThread = new SnakeThread(this); //create a new SnakeThread object and pass it the SnakeModel object
        snakeThread.start(); //start the thread
        snake=new Snake(0,0,Direction.RIGHT);
        goodfood= new Food(rand.nextInt(0,width),rand.nextInt(0,width));
        badFood= new Food(rand.nextInt(10,width),rand.nextInt(10,height));
        neutralFood= new Food(rand.nextInt(0,width),rand.nextInt(0,height));
        state=GameState.MENU;
    }

    /**
     * This method is used to get the snake object
     * @return snake
     */
    public Snake getSnake(){
        return snake;
    }
    /**
     * This method is used to get the good food object
     * @return goodfood
     */
    public Food getGoodFood(){
        return goodfood;
    }
    /**
     * This method is used to get the bad food object
     * @return badFood
     */
    public Food getBadFood(){
        return badFood;
    }
    /**
     * This method is used to get the neutral food object
     * @return neutralFood
     */
    public Food getNeutralFood(){return neutralFood;}
    /**
     * This method is used to get the state of the game
     * @return state
     */
    public GameState getState(){
        return state;
    }
    /**
     * This method is used to set the state of the game
     * @param state
     */
    public void setState(GameState state){
        this.state=state;
    }
    /**
     * This method is used to set the direction of the snake
     * @param direction
     */
    public void setDirection(Direction direction){
        snake.setDirection(direction);
        System.out.println(snake);
    }
    /**
     * This method is used to get the time left to the player
     * @return time
     */
    public int getTime(){
        return time;
    }


    /**
     * This method is used to get the direction of the snake
     * @return direction
     */

    public Direction  getDirection(){
        return snake.getDirection();
    }
    /**
     * This method is used to generate a food
     * @param food to generate a new position
     */
    private  void generateFood(Food food){
        food.setX(rand.nextInt(0,width));
        food.setY(rand.nextInt(0,width));
        changeCoordinatesOnCollission();
    }

    /**
     * This method is used to check if the game is over it uses streams and lambda functions.
     * it verifies if the game is over by checking the time and the score
     * @return true if the game is over, false otherwise
     */
    private boolean isGameOver() {
        if(time<=0 && score<MAXIMUMSCORE)return true;
        return IntStream.range(1, snake.getxCoordinates().size())
                .anyMatch(i -> snake.getxCoordinates().get(0) == snake.getxCoordinates().get(i)
                        && snake.getyCoordinates().get(0) == snake.getyCoordinates().get(i));
    }

    /**
     * This method is used to move the snake by verifying the direction of the snake
     */
     private void move(){
             for(int i = snake.getxCoordinates().size()-1;i>0;i--) {
                 snake.getxCoordinates().set(i,snake.getxCoordinates().get(i-1)) ;
                 snake.getyCoordinates().set(i,snake.getyCoordinates().get(i-1)) ;
             }
             snake.getxCoordinates().set(0,snake.getxCoordinates().get(0) +(snake.getDirection()==Direction.RIGHT ? 1:
                 (snake.getDirection()==Direction.LEFT ? -1:0)));//update the snake position if the snake is moving right add 1 to the x coordinate if the snake is moving left subtract 1 from the x coordinate
             snake.getyCoordinates().set(0,snake.getyCoordinates().get(0) +(snake.getDirection()==Direction.DOWN ? 1:
                 (snake.getDirection()==Direction.UP ? -1:0))); //
     }

     /**
      * It controls the logic of the game. 
      *it verifies if the snake collides with the food, if the snake collides with the food it increases the size of the snake and generates a new food.
      *it verifies if the snake collides with the wall, if the snake collides with the wall it continues on the opposite wall
      *it increases the score of the player if the snake collides with the food and if the snake collides with the bad food it decreases the size of the snake 
      */
   public void play(){
       time--;
       messageNumber=0;
       //if(score==MAXIMUMSCORE && time>0) setState(GameState.WIN);
       if(isGameOver()){
           setState(GameState.GAMEOVER);
           System.out.println("GameOver you loose");
       }
       else if (score>=MAXIMUMSCORE && time>=0) setState(GameState.WIN); ;

       continueOnOppositeWall();
      if(getState()==GameState.PLAYING) {
        move();
        if (collissionWithFood(goodfood)) {// if the snake eats the food increase the size of the snake and generate a new food, increase the score by 1
            score++;
            messageNumber=1;
            generateFood(goodfood);
            snake.increaseSize();
            System.out.println("collission With Good Food With good food");
            generateFood(goodfood);
        }
          if (collissionWithFood(neutralFood)) {// if the snake eats the food increase the size of the snake and generate a new food, increase the score by 1
              messageNumber=3;
              generateFood(neutralFood);

              System.out.println("collission With Neutral Food With good food");
              generateFood(neutralFood);
          }
        if (collissionWithFood(badFood)) {// if the snake eats the food increase the size of the snake and generate a new food, increase the score by 1
            score--;
            messageNumber = 2;
            System.out.println("collission WithFood With bad food");
            generateFood(badFood);
            if (this.state != GameState.GAMEOVER && snake.getxCoordinates().size() > 2) {
                snake.decreaseSize();
            } else setState(GameState.GAMEOVER);
        }

      }

    continueOnOppositeWall();
 System.out.println(this.toString());
}


/**
 *  This method is used to check if the snake collides with the food

 * @return true if the snake collides with the food, false otherwise
 */
private boolean collissionWithFood(Food f){
    return snake.getxCoordinates().get(0) == f.getX() && snake.getyCoordinates().get(0) == f.getY();
}
 /**
  * This method is used to get the message number
  * @return messageNumber
  */
 public int getMessageNumber(){
     return  messageNumber;
 }

    /**
     * This method is used to get the score
     * @return score
     */
    public  int getScore(){
     return score;
 }
   /**
    * This method is used to continue the way of the snake if it collides with the wall
    */
 private void continueOnOppositeWall(){
    if(snake.getxCoordinates().get(0)<0){
        snake.getxCoordinates().set(0,width-1);
    }
    else if (snake.getxCoordinates().get(0)>width-1){
        snake.getxCoordinates().set(0,0);
    }
    else if(snake.getyCoordinates().get(0)<0){
        snake.getyCoordinates().set(0,height-1);
    }
    else if(snake.getyCoordinates().get(0)>height-1)
        snake.getyCoordinates().set(0,0);
}
/**
 * This method is used to reset the game by setting the snake to its initial position,
 *  setting the direction of the snake to right,
 *  setting the score to 0, setting the time to 700, 
 * setting the message number to 0, setting the state to MENU and generating a new food
 */
public void reset(){
    snake= new Snake(0,0,Direction.RIGHT);
    score=0;
    time=700;
    messageNumber=0;
    state=GameState.MENU;
    generateFood(goodfood);
    generateFood(badFood);
    generateFood(neutralFood);
}
private void changeCoordinatesOnCollission() {
    if (goodfood.getX() == badFood.getX() && goodfood.getY() == badFood.getY())
        generateFood(goodfood);

    if (goodfood.getX() == neutralFood.getX() && goodfood.getY() == neutralFood.getY())
        generateFood(neutralFood);

    if (badFood.getX() == neutralFood.getX() && badFood.getY() == neutralFood.getY())
        generateFood(badFood);

}

 /**
     * This method is used to print the food in the console
     */
  @Override
  public String  toString(){
    String s="";
    s+="Snake: "+snake.toString()+ "  pos: "+ "("+snake.getxCoordinates().getFirst() +","+snake.getyCoordinates().getFirst()+")"+"\n";
    s+=" The Good Food: "+getGoodFood().toString()+"\n";
    s+=" The bad Food: "+getBadFood().toString()+"\n";
    s+=" The neutral Food: "+getNeutralFood().toString()+"\n";
    s+="Score: "+getScore()+"\n";
    s+="State: "+getState()+"\n";
    return s;
  }
}
/* Zeit der Stickers
* Jshell.exe --class-path .\out\production\snake\
* import Model.*;
 * die Art und Weise wie ich meine Bilder geladen habe
 */

/* TODO this Weekend
*Verifier les MUST have
* JAVADOC
* Unit TEST
 */