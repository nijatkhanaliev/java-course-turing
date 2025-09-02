package az.edu.turing.designpatterns.observerpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4);

        executorService.scheduleAtFixedRate(new Thread(new ProducerThread()), 10, 80, TimeUnit.MILLISECONDS);
        executorService.scheduleWithFixedDelay(new Thread(new ConsumerThread()), 12, 20,TimeUnit.MILLISECONDS);

        Thread.sleep(4000);
        executorService.shutdown();

        System.out.println(list);
    }

}
