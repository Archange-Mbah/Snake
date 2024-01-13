package SnakeGame.Test;

import SnakeGame.Model.Direction;
import SnakeGame.Model.GameState;
import SnakeGame.Model.SnakeModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SnakeModelTest {
    private SnakeModel model;
    @BeforeEach
    void setUp(){
        model= new SnakeModel();
    }
    @AfterEach
    void tearDown(){}


    @Test
     void testStates(){
        assertEquals(model.getState(),GameState.MENU);
        assertNotEquals(model.getState(),GameState.PLAYING);
        assertNotEquals(model.getState(),GameState.GAMEOVER);
        assertNotEquals(model.getState(),GameState.WIN);
        model.setState(GameState.PLAYING);
    }
    @Test
    void testInitialisationOfVariables(){
        assertNotNull(model.getNeutralFood());
        assertNotNull(model.getBadFood());
        assertNotNull(model.getGoodFood());
        assertNotNull(model.getSnake());
        assertNotEquals(model.getNeutralFood(),model.getGoodFood());
        assertNotNull(model.getSnake());
        assertEquals(model.getScore(),0);
        assertEquals(model.getTime(),700);
        assertNotEquals(model.getMessageNumber(),4);
        assertEquals(model.getDirection(),Direction.RIGHT);
    }




}
