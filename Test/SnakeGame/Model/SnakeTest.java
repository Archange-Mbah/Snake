package SnakeGame.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnakeTest {
 Snake snake;
    @BeforeEach
    void setUp() {
        snake=new Snake(3,4,Direction.RIGHT);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getxCoordinates() {
        assertEquals(3,snake.getxCoordinates().get(0));
    }

    @Test
    void getyCoordinates() {
        assertEquals(4,snake.getyCoordinates().get(0));
    }

    @Test
    void setDirection() {
        snake.setDirection(Direction.RIGHT);
        snake.setDirection(Direction.DOWN);
        assertNotEquals(snake.getDirection(),Direction.RIGHT);
    }

    @Test
    void getDirection() {
        assertNotEquals(snake.getDirection(),Direction.LEFT);
    }

    @Test
    void increaseSize() {
        snake.increaseSize();
        assertEquals(snake.getxCoordinates().size(),3);
        snake.setDirection(Direction.DOWN);
        snake.toString();
        snake.increaseSize();
        snake.setDirection(Direction.UP);
        snake.toString();
        snake.increaseSize();
        snake.setDirection(Direction.LEFT);
        snake.toString();
        snake.increaseSize();

    }

    @Test
    void decreaseSize() {
        snake.decreaseSize();
        assertNotEquals(snake.getxCoordinates().size(),3);
    }

    @Test
    void testToString() {
        assertNotEquals(snake.toString(),"snake");
        snake.setDirection(Direction.DOWN);

        snake.setDirection(Direction.UP);

        snake.setDirection(Direction.LEFT);

    }
}