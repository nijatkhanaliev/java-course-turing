package az.edu.turing.module3.lesson08;

import java.util.List;

public class MyConsumer implements Runnable{
    private final List<Integer> list;

    public MyConsumer(List<Integer> list) {
        this.list = list;
    }


    @Override
    public void run() {
        synchronized (this){
            if(!list.isEmpty())
                System.out.println(list.removeFirst() + " removed ");
        }

    }
}
