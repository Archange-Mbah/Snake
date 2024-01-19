package SnakeGame.Model;

import java.util.Random;

/**
 * SnakeThread is used to create a thread that will be used to change the position of the foods every 7 seconds
 */


public class SnakeThread  extends Thread{
    private SnakeModel model;
    Random random= new Random();
    /**
     * This constructor is used to create a SnakeThread object
     * @param model is an object of the SnakeModel class
     */
    public SnakeThread(SnakeModel model){
        this.model=model;
    }


    
    /**
     * This method is used to change the position of the foods every 7 seconds
     */
    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(6000);
                model.getGoodFood().setX(random.nextInt(3,25));
                model.getGoodFood().setY(random.nextInt(3,20));
                model.getBadFood().setX(random.nextInt(5,25));
                model.getBadFood().setY(random.nextInt(4,20));
                model.getNeutralFood().setX(random.nextInt(6,25));
                model.getNeutralFood().setY(random.nextInt(5,20));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }


}
