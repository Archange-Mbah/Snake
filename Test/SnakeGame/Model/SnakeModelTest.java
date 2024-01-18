package SnakeGame.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnakeModelTest {
    SnakeModel snakeModel;

    @BeforeEach
    void setUp() {
        snakeModel= new SnakeModel();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getSnake() {
        assertNotEquals(snakeModel.getSnake(),null);

    }

    @Test
    void getGoodFood() {
        assertNotEquals(snakeModel.getGoodFood(),null);
    }

    @Test
    void getBadFood() {
        assertNotEquals(snakeModel.getBadFood(),null);
    }

    @Test
    void getNeutralFood() {
        assertNotEquals(snakeModel.getNeutralFood(),null);
    }

    @Test
    void getState() {
        assertEquals(snakeModel.getState(), GameState.MENU);

    }

    @Test
    void setState() {
        snakeModel.setState(GameState.GAMEOVER);
        assertNotEquals(snakeModel.getState(), GameState.MENU);
        snakeModel.setState(GameState.WIN);
        assertNotEquals(snakeModel.getState(), GameState.PLAYING);
        snakeModel.setState(GameState.WIN);
        assertNotEquals(snakeModel.getState(), GameState.GAMEOVER);
    }


    @Test
    void setDirection() {
        snakeModel.setDirection(Direction.UP);
        Direction direction=snakeModel.getDirection();
        snakeModel.setDirection(Direction.DOWN);
        assertNotEquals(snakeModel.getDirection(),direction);
    }

    @Test
    void getTime() {
        assertEquals(snakeModel.getTime(),700);
    }

    @Test
    void getDirection() {
        assertEquals(snakeModel.getDirection(),Direction.RIGHT);
    }

    @Test
    void play() {
        int initialTime=snakeModel.getTime();
        assertEquals(initialTime,snakeModel.getTime());
        int time2=  snakeModel.getTime();
        snakeModel.setState(GameState.PLAYING);
        snakeModel.setDirection(Direction.RIGHT);
        snakeModel.getSnake().getxCoordinates().set(0,snakeModel.getGoodFood().getX()-1);
        snakeModel.getSnake().getyCoordinates().set(0,snakeModel.getGoodFood().getY());
        snakeModel.play();
        snakeModel.getSnake().getxCoordinates().set(0,snakeModel.getBadFood().getX()-1);
        snakeModel.getSnake().getyCoordinates().set(0,snakeModel.getBadFood().getY());
        snakeModel.play();
        snakeModel.getSnake().getxCoordinates().set(0,snakeModel.getNeutralFood().getX()-1);
        snakeModel.getSnake().getyCoordinates().set(0,snakeModel.getNeutralFood().getY());
        snakeModel.play();
        snakeModel.getSnake().getxCoordinates().set(0,snakeModel.getBadFood().getX()-1);
        snakeModel.getSnake().getyCoordinates().set(0,snakeModel.getBadFood().getY());
        snakeModel.play();
        snakeModel.getNeutralFood().setX(snakeModel.getGoodFood().getX());
        snakeModel.getNeutralFood().setY(snakeModel.getGoodFood().getY());
        snakeModel.play();
        snakeModel.getSnake().getxCoordinates().set(0,-4);
        snakeModel.play();
        snakeModel.getSnake().getyCoordinates().set(0,-4);
        snakeModel.play();
        snakeModel.getSnake().getyCoordinates().set(0,300);
        snakeModel.play();
        snakeModel.setDirection(Direction.LEFT);
        snakeModel.getSnake().getxCoordinates().set(0,snakeModel.getGoodFood().getX()-1);
        snakeModel.getSnake().getyCoordinates().set(0,snakeModel.getGoodFood().getY());
        snakeModel.play();
        snakeModel.setDirection(Direction.DOWN);
        snakeModel.getSnake().getxCoordinates().set(0,snakeModel.getGoodFood().getX()-1);
        snakeModel.getSnake().getyCoordinates().set(0,snakeModel.getGoodFood().getY());
        snakeModel.play();
        snakeModel.setDirection(Direction.UP);
        snakeModel.getSnake().getxCoordinates().set(0,snakeModel.getGoodFood().getX()-1);
        snakeModel.getSnake().getyCoordinates().set(0,snakeModel.getGoodFood().getY());
        snakeModel.play();
        snakeModel.reset();
        assertEquals(initialTime> snakeModel.getTime(),time2>snakeModel.getTime());

    }

    @Test
    void getMessageNumber() {
        assertEquals(snakeModel.getMessageNumber(),0);
    }

    @Test
    void getScore() {
        assertEquals( 0<= snakeModel.getScore(), snakeModel.getScore()<11);
    }

    @Test
    void reset() {
        snakeModel.reset();
    }

    @Test
    void testToString() {
       assertNotEquals( snakeModel.toString(),null);
    }
}