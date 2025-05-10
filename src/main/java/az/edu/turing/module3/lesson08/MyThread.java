package az.edu.turing.module3.lesson08;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("Thread running: " + Thread.currentThread().getName() + " priority: " + Thread.currentThread().getPriority());
    }
}
