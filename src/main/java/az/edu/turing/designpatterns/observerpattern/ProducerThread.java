package az.edu.turing.designpatterns.observerpattern;

public class ProducerThread implements Runnable{
    @Override
    public void run() {
        synchronized (this) {
            int randomInteger = (int) (1000 + (Math.random()*10000));
            Main.list.add(randomInteger);
            System.out.println("random integer in producer: "+randomInteger);

        }
    }
}
