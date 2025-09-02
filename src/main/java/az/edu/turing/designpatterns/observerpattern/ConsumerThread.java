package az.edu.turing.designpatterns.observerpattern;

public class ConsumerThread implements Runnable {

    @Override
    public void run() {
        synchronized (this){
            if(!Main.list.isEmpty()){
                Integer removedElement = Main.list.removeFirst();
                System.out.println("removed element in consumer: " + removedElement);
            }
        }

    }
}
