import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;


public class Table implements Runnable {
    private final List<Philosopher> philosophers;
    private CountDownLatch cdl; // блокирует поток пока значение >0
    private static final int NUM_PHILOSOPHERS = 5;
    private static Semaphore[] forks;


    public Table() {
        cdl = new CountDownLatch(NUM_PHILOSOPHERS);
        philosophers = new ArrayList<>();
        forks = new Semaphore[NUM_PHILOSOPHERS];
        createForks();

        philosophers.add(new Philosopher("Василий", cdl, forks[0], forks[1]));
        philosophers.add(new Philosopher("Петр", cdl, forks[1], forks[2]));
        philosophers.add(new Philosopher("Семен", cdl, forks[2], forks[3]));
        philosophers.add(new Philosopher("50_Cent", cdl, forks[3], forks[4]));
        philosophers.add(new Philosopher("Eminem", cdl, forks[4], forks[0]));
    }


    @Override
    public void run() {
        try {
            goOnStart();
            cdl.await();
            System.out.println(System.lineSeparator() + "Все сели за стол" + System.lineSeparator());
            startEat();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void createForks() {
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new Semaphore(1); // Изначально все вилки свободны
        }
    }

    private void goOnStart() {
        for (Philosopher philosopher : philosophers) {
            new Thread(philosopher).start();
        }
    }

    private void startEat() throws InterruptedException {
        for (Philosopher philosopher : philosophers) {
            philosopher.go();
        }
    }

}
