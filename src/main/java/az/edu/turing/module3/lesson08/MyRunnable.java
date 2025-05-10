package az.edu.turing.module3.lesson08;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread is running: " + Thread.currentThread().getName() + " priority: " + Thread.currentThread().getPriority());
    }
}
