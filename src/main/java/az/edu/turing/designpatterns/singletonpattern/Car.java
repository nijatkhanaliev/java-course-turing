package az.edu.turing.designpatterns.singletonpattern;

public class Car {
    private String name;
    private int year;

    public Car() {
    }

    private Car(String name, int year){
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private static Car instance = null;

    public static Car getCar(){
        if(instance==null){
            instance = new Car();
        }

        return instance;
    }

}
