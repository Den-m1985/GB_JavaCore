import java.util.Scanner;

public class StartsHelper {
    private static int cnt = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread readThread = new Thread(()->{
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine() && !Thread.interrupted()){
                scanner.nextLine();
                cnt++;
            }
        });
        readThread.setDaemon(true);
        readThread.start();
        readThread.interrupt();

        while (true) {
            System.out.println(cnt + " message");
            Thread.sleep(1000);
        }
    }


}
