package az.edu.turing.module1.lesson05;

import java.util.Arrays;

public class StringLesson {

    public static void main(String[] args) {
        //System.out.println(args[0] +" " + args[1]);

        String s = "hello";
        s = "go to course"; //this creates new string object in pool
        String s2 = null;
        System.out.println(s+s2);// + convert all to string

        changeString(s);
        System.out.println(s);

        System.out.println(s.indexOf('e'));
        System.out.println(s.equalsIgnoreCase("HeLlO"));

        System.out.println(s.replace('l','*'));
        System.out.println(Arrays.toString(s.split("")));
        System.out.println(s.replaceFirst("[l]","*"));

        String newS =  s.replaceAll("[A-Ea-e]","*");
        System.out.println(newS);

        int[] arr = {1,2,3,4};
        changeArr(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.fill(arr,1);
        System.out.println(Arrays.toString(arr));

        int a = 4;
        System.out.printf("salam %d",4);
        System.out.println();
        changePrimitive(a);
        System.out.println(a);


        String t = new String("hello").intern();
        String h = new String("hello");
        System.out.println(h==s);
        System.out.println(t==h);

    }

    public static void changeArr(int[] arr) {
        arr[0] = 101;
    }

    public static void changePrimitive(int a){
         a = 7;
    }

    public static void changeString(String s){
        s = "go to course";
    }

}
