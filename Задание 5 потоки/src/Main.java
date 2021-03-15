import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter(1);
        long start = System.currentTimeMillis();
        Timer mytimer = new Timer();
        mytimer.schedule(new MyTimerTask(start,counter), 0,5000);

    }
}
