package az.edu.turing.module3.lesson09;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        String folderPath = "C://Users//user//Desktop//test";
        File directory = new File(folderPath);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if(files!=null){
                for (File file1 : files) {
                    if (file1.isFile() && file1.getName().endsWith(".txt")) {
                        MyThread thread = new MyThread(file1.getAbsolutePath(),file1.getName());
                        executorService.submit(thread);
                    }
                }
            }

        }

        executorService.shutdown();
        
    }
}
