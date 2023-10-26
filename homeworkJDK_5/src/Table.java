import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.sleep;

public class Table implements Runnable {
    private final List<Philosopher> philosophers;
    //private List<String> table;
    private CountDownLatch cdl; // блокирует поток пока значение >0
    private MyProgramState state;


    public Table() {
        cdl = new CountDownLatch(5);
        state = new MyProgramState();
        philosophers = new ArrayList<>();
        int countPlates = 3;
        philosophers.add(new Philosopher("Василий", cdl, state, countPlates));
        philosophers.add(new Philosopher("Петр", cdl, state, countPlates));
        philosophers.add(new Philosopher("Семен", cdl, state, countPlates));
        philosophers.add(new Philosopher("50Cent", cdl, state, countPlates));
        philosophers.add(new Philosopher("Aminem", cdl, state, countPlates));

        List<Integer> forks = new ArrayList<>();
        for (int i = 0; i < philosophers.size(); i++) forks.add(i);



    }


    @Override
    public void run() {
        try {
            goOnStart();
            cdl.await();

            System.out.println(System.lineSeparator() + "Все сели за стол" + System.lineSeparator());
            startEat();
            cdl.await();

            sta();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    private void goOnStart() {
        for (Philosopher philosopher : philosophers) {
            startThread(philosopher);
        }
    }


    private void startThread(Runnable runnable) {
        new Thread(runnable).start();
    }


    private void startEat() throws InterruptedException {
        for (Philosopher philosopher : philosophers) {
            philosopher.go();
        }
    }


    private void startThink() throws InterruptedException {
        for (Philosopher philosopher : philosophers) {
            philosopher.go();
        }
    }

    private void sta() throws InterruptedException {
        while (!state.isFinish()) {
            //поменяли флаг
            state.setSwitcher(!state.isSwitcher());
            if (!state.isSwitcher()) {
                System.out.println("пауза");
            }
            sleep(1000);
        }
    }

//    private void createTable(){
//        table = new ArrayList<>();
//        for (int i = 0; i < 15; i++) {
//            String name = philosophers.get(i).getName();
//            table.add("вилка левая " + name);
//            table.add(name);
//            table.add("вилка правая " + name);
//        }
//    }


}
