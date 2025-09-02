package az.edu.turing.module3.lesson08;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4);
        executorService.scheduleAtFixedRate(new MyProcedure(list), 0, 100, TimeUnit.MILLISECONDS);
        executorService.scheduleWithFixedDelay(new MyConsumer(list),0,200,TimeUnit.MILLISECONDS);

        Thread.sleep(5000);
        executorService.shutdown();
        System.out.println(list);
    }

}
