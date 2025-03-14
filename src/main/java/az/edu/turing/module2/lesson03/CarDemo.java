package az.edu.turing.module2.lesson03;

public class CarDemo {
    public static void main(String[] args) {
        Car car = new Hyundai();
        car.setName("Sonata");
        car.setColor("black");
        car.setModel("hyundai");
        car.start();

        Mercedes mercedes = new Mercedes();
        mercedes.setName("Gl");
        mercedes.setColor("black");
        mercedes.setModel("mercedes");
        mercedes.fly();
        mercedes.start();
        System.out.println(mercedes.getMaskedName("mercedes"));


        Flyable mercedes1 = new Mercedes();
        System.out.println(mercedes1.getMaskedName("mercedes1"));
        System.out.println(Flyable.getMaskedName(84483706));

    }
}
