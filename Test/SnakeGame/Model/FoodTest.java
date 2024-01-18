package SnakeGame.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {
  Food food;
    @BeforeEach
    void setUp() {
        food=new Food(3,4);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setX() {
        food.setX(6);
        assertEquals(food.getX(),6);

    }

    @Test
    void setY() {
        food.setY(5);
        assertEquals(food.getY(),5);
    }

    @Test
    void getX() {
        assertEquals(food.getX(),3);
    }

    @Test
    void getY() {
        assertEquals(food.getY(),4);
    }

    @Test
    void testToString() {
        assertNotEquals(food.toString(),"blabla");
    }
}