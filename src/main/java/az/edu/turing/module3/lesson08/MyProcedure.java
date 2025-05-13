package az.edu.turing.module3.lesson08;


import java.util.List;

public class MyProcedure implements Runnable{
    private final List<Integer> list;

    public MyProcedure(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (this){
            double random = Math.ceil(Math.random() * 100);
            System.out.println(list.add((int) random) + "  added ");
        }
    }
}
