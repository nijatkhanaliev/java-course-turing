package az.edu.turing.module3.lesson04;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        set.add(2);
        set.remove(1);

        System.out.println(set);

    }

}
