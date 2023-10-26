import java.util.Random;
import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.sleep;

public class Philosopher implements Runnable {
    private String name;
    private String eat = "eat";
    private String think = "think";
    private boolean eatOrThink;
    private int countPlates;
    private CountDownLatch cdl;
    private Random random;
    private MyProgramState state;

    public Philosopher(String name, CountDownLatch cdl, MyProgramState state, int countPlates) {
        this.name = name;
        this.cdl = cdl;
        this.countPlates = countPlates;
        this.state = state;
        random = new Random();
    }


    public String setEatOrThink() {
        if (state.isSwitcher()) {
            return eat;
        } else {
            return think;
        }
    }


    @Override
    public void run() {
        try {
            goOnTable();
            synchronized (this) {
                wait();
            }
            godghhfg();

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
        sleep(1000L);
        System.out.println(name + " начал " + setEatOrThink());
    }


    public void godghhfg() {
        while (!state.isFinish() && countPlates > 0) {
            if (state.isSwitcher()) {
                System.out.println(name + " осталось съесть " + countPlates-- + " тарелок спагети");
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        state.setFinish(true);
    }

    public String getName() {
        return name;
    }
}
