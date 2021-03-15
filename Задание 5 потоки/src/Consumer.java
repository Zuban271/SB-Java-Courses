import static java.lang.Thread.sleep;

public class Consumer implements Runnable {
    private Counter counter;

    private String name;

    public Consumer(Counter counter, String name) {
        this.counter = counter;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " " + counter.inc());
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
