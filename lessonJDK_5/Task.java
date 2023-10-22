import java.util.concurrent.CountDownLatch;

public class Task implements Runnable {
    private int value;
    private CountDownLatch cdl;

    public Task(int left) {
        this.value = left;
    }


    @Override
    public void run() {
        //System.out.println(value);
        for (int i = 0; i < 10_000_000; i++) {
            inc();
        }
        cdl.countDown();
    }

    public synchronized void inc() {
        value++;
    }

    public int getValue() {
        return value;
    }

    public void setCdl(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    @Override
    public String toString() {
        return String.format("(%s)", value);
    }
}
