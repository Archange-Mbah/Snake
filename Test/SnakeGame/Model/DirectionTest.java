package SnakeGame.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {
    Direction  direction;
    @BeforeEach
    void setUp() {
        direction=Direction.UP;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void values() {
        assertNotEquals(direction,Direction.RIGHT);
        assertNotEquals(direction,Direction.LEFT);
        assertNotEquals(direction,Direction.DOWN);
    }

    @Test
    void valueOf() {
    }
}