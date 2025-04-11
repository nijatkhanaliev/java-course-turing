package az.edu.turing.module3.lesson02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        Supplier<String> stringSupplier = ()-> "salam";
        Predicate<String> stringPredicate = (s)-> s.length()>3;
        Consumer<String> stringConsumer = (s)-> System.out.println("result: " + (s) + " length: " + s.length());
        Function<String,String> stringFunction = (s)-> "Length: " + s.length() ;

        String s = "he";

        Optional.of(s)
                .filter(stringPredicate)
                .map(stringFunction)
                .ifPresentOrElse(stringConsumer,()-> System.out.println(stringSupplier.get()));


    }


    public static void comparablePractice(){
        Car[] cars = {
                new Car("Bmw",260),
                new Car("Mercedes",240),
                new Car("Hyundai",220),
                new Car("Lada",180),
                new Car("Ford",200)
        };

        Arrays.sort(cars);

        System.out.println(Arrays.toString(cars));
    }

    public static void comparatorNameAsc(){
        Car[] cars = {
                new Car("Bmw",260),
                new Car("Mercedes",240),
                new Car("Hyundai",220),
                new Car("Lada",180),
                new Car("Ford",200)
        };

        Comparator<Car> carComparatorNameAsc = (o1,o2)->{
            System.out.println("name sorted ascended");
            return o1.getName().compareTo(o2.getName());
        };

        Arrays.sort(cars,carComparatorNameAsc);
        System.out.println(Arrays.toString(cars));
    }

    public static void comparatorSpeedAsc(){
        Car[] cars = {
                new Car("Bmw",260),
                new Car("Mercedes",240),
                new Car("Hyundai",220),
                new Car("Lada",180),
                new Car("Ford",200)
        };

        Comparator<Car> carComparatorSpeedAsc = Comparator.comparingInt(Car::getSpeed);

        Arrays.sort(cars,carComparatorSpeedAsc);
        System.out.println(Arrays.toString(cars));
    }

    public static void comparatorSpeedDesc(){
        Car[] cars = {
                new Car("Bmw",260),
                new Car("Mercedes",240),
                new Car("Hyundai",220),
                new Car("Lada",180),
                new Car("Ford",200)
        };

        Comparator<Car> carComparatorSpeedDesc = (o1,o2) -> o2.getSpeed()-o1.getSpeed();


        Arrays.sort(cars,carComparatorSpeedDesc);
        System.out.println(Arrays.toString(cars));
    }

}
