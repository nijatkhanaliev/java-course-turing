package az.edu.turing.module3.lesson09.wordcounter;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static AtomicInteger count = new AtomicInteger(0);
    public static ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        String folderName = "C://Users//user//Desktop//test";
        File directory = new File(folderName);
        ExecutorService service = Executors.newCachedThreadPool();

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        String fileName = file.getAbsolutePath();
                        FileWordCounterTask task = new FileWordCounterTask(fileName);
                        service.submit(task);
                    }
                }
            }
        }

        service.shutdown();
        service.awaitTermination(Long.MAX_VALUE,TimeUnit.NANOSECONDS);
        System.out.println("Total Words: " + count);
        System.out.println(map);

    }
}
