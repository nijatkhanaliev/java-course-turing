package az.edu.turing.module2.lesson03;

public final class Mercedes extends Car implements Flyable{

    @Override
    public void start() {
        System.out.println("start with button");
    }

    @Override
    public void stop() {
        System.out.println("stop with button");
    }

    @Override
    public void fly() {
        System.out.println("fly with gas");
    }

    @Override
    public String getMaskedName(String name){
        return "Mercedes class override";
    }
}
