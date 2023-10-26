import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Philosopher implements Runnable {
    private final String name;
    private CountDownLatch cdl;
    private Random random;
    private final Semaphore leftFork;
    private final Semaphore rightFork;
    private static final int MEAL_LIMIT = 3; // Максимальное количество съеденных тарелок
    private int mealsEaten = 0;

    public Philosopher(String name, CountDownLatch cdl, Semaphore leftFork, Semaphore rightFork) {
        this.name = name;
        this.cdl = cdl;
        random = new Random();
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }


    @Override
    public void run() {
        try {
            goOnTable();
            synchronized (this) {
                wait();
            }
            while (mealsEaten < MEAL_LIMIT) {
                think();
                takeForks();
                eat();
                putForks();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void goOnTable() throws InterruptedException {
        sleep(random.nextInt(2, 5) * 1000L);
        System.out.println(name + " сел за стол");
        cdl.countDown();
    }

    public void go() throws InterruptedException {
        synchronized (this) {
            notify();
        }
        sleep(random.nextInt(1, 3) * 1000L);
    }

    private void think() throws InterruptedException {
        System.out.println(name + " is thinking.");
        Thread.sleep(random.nextInt(2, 5) * 1000L);
    }

    private void takeForks() throws InterruptedException {
        leftFork.acquire();
        System.out.println(name + " has taken left forks");
        rightFork.acquire();
        System.out.println(name + " has taken right forks");
    }

    private void eat() throws InterruptedException {
        mealsEaten++;
        if (mealsEaten == MEAL_LIMIT) {
            System.out.println(name + " is overeat spaghetti  +++++++++++++++++");
        } else {
            System.out.println(name + " is eating " + mealsEaten + " plate spaghetti");
        }

        Thread.sleep(random.nextInt(2, 5) * 1000L);
    }

    private void putForks() {
        leftFork.release();
        System.out.println(name + " has put down left forks");
        rightFork.release();
        System.out.println(name + " has put down right forks");
    }

}
