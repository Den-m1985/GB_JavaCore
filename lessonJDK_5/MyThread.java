public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from 1 " + Thread.currentThread());
    }
}
