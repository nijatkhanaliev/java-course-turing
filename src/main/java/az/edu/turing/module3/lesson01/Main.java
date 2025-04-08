package az.edu.turing.module3.lesson01;

public class Main {
    public static void main(String[] args) {


    }

    public static void storeObjects(){
        CustomStorage customStorage = new CustomStorage();

        customStorage.add(6); // int automatically auto boxes into Integers
        customStorage.add(6.7);
        customStorage.add(29);
        customStorage.add(76.745);

        customStorage.remove(0);
        System.out.println(customStorage.get(0));

        int a = (int) customStorage.get(0); // cast exception
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
