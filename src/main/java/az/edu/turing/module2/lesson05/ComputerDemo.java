package az.edu.turing.module2.lesson05;

public class ComputerDemo {
    public static void main(String[] args) {
        Computer desk = new Desktop();
        Computer lap = new Desktop(); // runtime polymorphism

        new Developer().code(desk);
        new Developer().code(lap);

    }
}
