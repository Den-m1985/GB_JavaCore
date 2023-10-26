public class TicTak implements Runnable {
    private final String brasket;
    private final Object monitor;

    public TicTak(String brasket) {
        this.brasket = brasket;
        this.monitor = TicTak.class;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (monitor) {
                System.out.print(brasket);
                try {
                    Thread.sleep(300);
                    monitor.notify();
                    monitor.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


}
