package az.edu.turing.module3.lesson09;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyThread implements Runnable {
    private final String fullFileName;
    private final String fileName;
    private int count;

    public MyThread(String fullFileName,String fileName) {
        this.fullFileName = fullFileName;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try(BufferedReader reader = new BufferedReader(new FileReader(fullFileName));) {
            while (reader.readLine()!=null) {
                count++;
            }

            System.out.println("Processing " + fileName + " by " + Thread.currentThread().getName() + " " + count);
        } catch (FileNotFoundException e) {
            System.out.println(Thread.currentThread().getName() + " exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println(Thread.currentThread().getName() + " exception: " + e.getMessage());
        }

    }

}
