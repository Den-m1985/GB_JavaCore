import java.util.concurrent.CountDownLatch;

public class Main1 {
    public static void main(String[] args) throws InterruptedException {
        Long start = System.currentTimeMillis();
//        System.out.println("fghf");
//        System.out.println(Thread.currentThread().getName());
//        for (int i = 0; i < 3; i++) {
//            new MyThread().start();
//        }
//        for (int i = 0; i < 5; i++) {
//            new Thread(new MyRunnable()).start();
//        }
//        for (int i = 0; i < 3; i++) {
//            new Thread(()->{
//                System.out.println("Hello from 3 " + Thread.currentThread());
//            }).start();
//        }

        Thread tic = new Thread(new TicTak("["));
        Thread tac = new Thread(new TicTak("]"));
        //tic.setDaemon(true);
        //tac.setDaemon(true);
        tic.start();
        tac.start();

//        Task task = new Task(0);
//        CountDownLatch cdl = new CountDownLatch(3);
//        task.setCdl(cdl);
//        for (int i = 0; i < 3; i++) {
//            Thread thread = new Thread(task);
//            thread.start();
//            //thread.join();
//        }
//        cdl.await();
//        System.out.println(task.getValue());

        //Long end = System.currentTimeMillis();
        //System.out.println("Time " + (end - start) + "ms");
    }
}
