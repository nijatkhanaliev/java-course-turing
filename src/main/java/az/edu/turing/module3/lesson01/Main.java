package az.edu.turing.module3.lesson01;

public class Main {
    public static void main(String[] args) {


    }

    public static void storeIntegers(){
        IntegerStorage integerStorage = new IntegerStorage(); // this works for only integers

        integerStorage.add(6);
        integerStorage.add(7);
        integerStorage.add(8);
        integerStorage.add(9);
        integerStorage.add(12);

        integerStorage.remove(4);
        System.out.println(integerStorage.get(3));
    }

}
