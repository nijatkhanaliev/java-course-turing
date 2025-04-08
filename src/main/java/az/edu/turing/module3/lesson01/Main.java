package az.edu.turing.module3.lesson01;


import java.io.Serializable;

public class Main {

    public static void main(String[] args) {
        GenericCustomStorage<Integer> generic = new GenericCustomStorage<>();
        generic.add(4);
        generic.add(7);

        int s = generic.get(0);
        System.out.println(s);
        System.out.println(generic.get(1));

        GenericCustomStorage<String> stringGeneric = new GenericCustomStorage<>();

        stringGeneric.add("salam");
        stringGeneric.add("necesen");

        String firstElement = stringGeneric.get(0);
        System.out.println(firstElement);
        System.out.println(stringGeneric.get(1));


        sumLowerBound(generic); // add 6
        System.out.println(generic.get(2)); //6

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

    public static void sumUnBound(GenericCustomStorage<?> nums){
        System.out.println(nums.get(0)); // works successfully
        //nums.add(4); // compile time exception
    }

    public static void sumUperBound(GenericCustomStorage<? extends Number> nums){
        System.out.println(nums.get(0)); // works successfully

        //nums.add(6); // compile time exception
    }

    public static void sumLowerBound(GenericCustomStorage<? super Integer> nums){
        nums.add(6); // works successfully
    }

}
