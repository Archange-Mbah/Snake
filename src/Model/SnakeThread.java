package Model;

import java.util.Random;


public class SnakeThread  extends Thread{
    SnakeModel model;
    Random random= new Random();
    public SnakeThread(SnakeModel model){
        this.model=model;
    }


    
    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(1000);
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
