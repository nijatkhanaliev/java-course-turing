package az.edu.turing.module3.lesson05;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
       List<String> list = Arrays.asList("nicat","salam","samir","salam","nicat");

       long count = list.stream()
               .distinct()
               .count();
        System.out.println(count);

        list.stream()
                .forEach((s)-> System.out.println(s.toUpperCase()));


        List<Integer> integers = List.of(1,2,3,4,5,6,7,8,9,12,23);

        int sum = integers.stream()
                .reduce(0,(a,b)->a+b);

        System.out.println(sum);

        Map<Integer,Integer> map = integers.stream()
                .collect(Collectors.toMap(i->i,i->i*3));


        System.out.println(map);



    }
}
