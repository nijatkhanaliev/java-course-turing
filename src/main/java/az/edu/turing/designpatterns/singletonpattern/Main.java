package az.edu.turing.designpatterns.singletonpattern;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        Car car = Car.getCar();
        car.setName("mercedes");

        Car car1 = Car.getCar();
        car1.setName("bmw");

        System.out.println(Objects.equals(car.getName(), car1.getName())); // true

    }
}
