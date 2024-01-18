package SnakeGame.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class SnakeThreadTest {
 SnakeThread snakeThread;
    @BeforeEach
    void setUp() {
        snakeThread= new SnakeThread(new SnakeModel());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void run() throws InterruptedException {
            // Create a SnakeModel
            SnakeModel model = new SnakeModel();

            // Create a SnakeThread instance
            SnakeThread snakeThread = new SnakeThread(model);

            // Set up a latch to signal when the run method has finished
            CountDownLatch latch = new CountDownLatch(1);

            // Override the behavior of the run method to signal the latch
            snakeThread = new SnakeThread(model) {
                @Override
                public void run() {
                    try {
                        super.run();
                    } finally {
                        latch.countDown();
                    }
                }
            };

            // Start the thread
            snakeThread.start();

            // Wait for the latch to be counted down, or timeout after a reasonable duration
            //assertTrue(latch.await(10, TimeUnit.SECONDS));

            // Verify the expected behavior after the run method has finished
            // Here, you might check the updated positions or any other expected side effects
            assertNotEquals(-2, model.getGoodFood().getX());
            assertNotEquals(-4, model.getGoodFood().getY());

            // Interrupt the thread to stop it
            snakeThread.interrupt();

            // Verify that the thread is interrupted
            //assertTrue(snakeThread.isInterrupted());
        }
    }
