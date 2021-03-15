import java.util.TimerTask;

import static java.lang.Thread.sleep;

class MyTimerTask extends TimerTask {
    private Long start;
    private Counter mycounter;
    public  MyTimerTask(Long Start,Counter mycounter) {
        this.start = Start;
        this.mycounter = mycounter;
    }
    @Override
    public void run() {
        System.out.println("выполняется задача MyTimertask");
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.printf("Прошло времени, с: %f\n", (float) elapsed/1000);
        if (elapsed >= 30000) {
            cancel();
            System.exit(0);
        }
        else {
            long start1 = System.currentTimeMillis();
            for (int i = 0; i < 3; i++) {
                Thread thread = new Thread(new Consumer(mycounter, "consumer_" + i));
                thread.start();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long finish1 = System.currentTimeMillis();
                long elapsed1 = finish1 - start1;
                if (elapsed1 >= 1000)
                System.out.printf("Прошло времени, с: %f\n", (float) elapsed1/1000);
            }
        }

    }
}
