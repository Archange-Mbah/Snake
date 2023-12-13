package Model;


/**
 * The java.util.Random class is used to generate a stream of pseudorandom numbers.
 */
import  java.util.Random;
/**
 * SnakeModel is used to create a  snake game Model
 */
public class SnakeModel implements Imodel{

     /**
      * snake is an object of the Snake class
      */
     private final Snake snake;
    /**
     * goodfood is an object of the Food class
     */
    private final Food goodfood;
    private final Food badFood;
    private GameState state;
    private final int width=25;
    private final int height=20;

    private int messageNumber=0;
    Random rand= new Random();


    private  int score=0;

    public static void main(String[] args){
        
        Snake s= new Snake(3,4,Direction.DOWN);
        SnakeModel c= new SnakeModel();
        System.out.println(s);
        System.out.println(c);
    }

    /**
     * This constructor is used to create a SnakeModel object
     */
    public SnakeModel(){
        SnakeThread snakeThread = new SnakeThread(this); //create a new SnakeThread object and pass it the SnakeModel object
        snakeThread.start(); //start the thread
        snake=new Snake(0,5,Direction.RIGHT);
        goodfood= new Food(rand.nextInt(0,width),rand.nextInt(0,width),true);
        badFood= new Food(rand.nextInt(0,width),rand.nextInt(0,height),false);
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
     * This method is used to get the direction of the snake
     * @return direction
     */

    public Direction  getDirection(){
        return snake.getDirection();
    }
    public void generateFood(Food f){     // to generate a new food..
        f.setX(rand.nextInt(0,width));
                                          //system.out.printLn("foodx"+f);
        f.setY(rand.nextInt(0,width));
    }

    /**
     * This method is used to check if the game is over
     * @return true if the game is over, false otherwise
     */
     public boolean isGameOver(){ // do this with lambda ausdruck
         for(int i=1;i<snake.getxCoordinates().size();i++){
                        if(snake.getxCoordinates().get(0)==snake.getxCoordinates().get(i)
                        && snake.getyCoordinates().get(0)==snake.getyCoordinates().get(i))
                        {    snake.getxCoordinates().clear();
                             snake.getyCoordinates().clear();
                              return true;
                        }
         }
            return false;
     }
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
      * This method is used to play the game
      */
   public void play(){
       messageNumber=0;
       if(isGameOver()){
           setState(GameState.GAMEOVER);
           System.out.println("GameOver you loose");
       }
       continueOnOppositeWall();
      if(getState()==GameState.PLAYING) {
        move();
        if (collissionWithGoodFood()) {// if the snake eats the food increase the size of the snake and generate a new food, increase the score by 1
            score++;
            messageNumber=1;
            generateFood(goodfood);
            snake.getxCoordinates().add(0, snake.getxCoordinates().get(0) + (snake.getDirection() == Direction.RIGHT ? 1 :
                    (snake.getDirection() == Direction.LEFT ? -1 : 0)));
            snake.getyCoordinates().add(0, snake.getyCoordinates().get(0) + (snake.getDirection() == Direction.DOWN ? 1 :
                    (snake.getDirection() == Direction.UP ? -1 : 0)));
            System.out.println("collission With Good Food With good food");
            generateFood(goodfood);
        }
        if (collissionWithBadFood()) {// if the snake eats the food increase the size of the snake and generate a new food, increase the score by 1
            score--;
            messageNumber = 2;
            System.out.println("collission WithFood With bad food");
            generateFood(badFood);
            if (this.state != GameState.GAMEOVER && snake.getxCoordinates().size() > 2) {
                snake.getxCoordinates().remove(snake.getxCoordinates().size() - 1);
                snake.getyCoordinates().remove(snake.getyCoordinates().size() - 1);
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
 public  boolean collissionWithGoodFood(){
     return snake.getxCoordinates().get(0) == goodfood.getX() && snake.getyCoordinates().get(0) == goodfood.getY();
 }
 public boolean collissionWithBadFood(){
     return snake.getxCoordinates().get(0) == badFood.getX() && snake.getyCoordinates().get(0) == badFood.getY();
 }
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
     * This method is used to print the food in the console
     */
  @Override
  public String  toString(){
    String s="";

    s+="Snake: "+snake.toString()+"\n";
    s+=" The good Food: "+getBadFood().toString()+"\n";
    s+=" The bad Food: "+getGoodFood().toString()+"\n";
    s+="Score: "+getScore()+"\n";
    s+="State: "+getState()+"\n";
    return s;
  }
  
  
}
