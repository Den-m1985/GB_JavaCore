import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class CME {
    public static void main(String[] args) {
        Queue<Integer> list = new ConcurrentLinkedDeque<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        Runnable r1 = () -> {
            for (int i = 0; i < 100; i++) {
                    list.add(i);
            }
        };
        Runnable r2 = () -> {
                for (Integer value : list) {
                    System.out.print(value + " ");
                }
        };
        new Thread(r1).start();
        new Thread(r2).start();
    }
}
