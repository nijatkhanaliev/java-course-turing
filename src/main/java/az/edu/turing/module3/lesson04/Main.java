package az.edu.turing.module3.lesson04;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) {
//        Set<Integer> set = new HashSet<>();
//        set.add(1);
//        set.add(1);
//        set.add(2);
//        set.remove(1);
//
//        System.out.println(set);

//        Queue<String> queue = new PriorityQueue<>();
//        queue.add("salam");
//        queue.add("necesen");
//        queue.add("alam");
//        System.out.println(queue.remove());
//        System.out.println(queue);
//       System.out.println(queue.poll());

//        Queue<String> queue = new LinkedBlockingQueue<>();
//        queue.add("salam");
//        queue.add("necesen");
//        queue.add("alam");
//        System.out.println(queue.remove());
//        System.out.println(queue);
//        System.out.println(queue.poll());

//        Stack<String> stack = new Stack<>();
//        stack.push("salam");
//        stack.push("hello");
//        stack.push("necesen");
//        System.out.println(stack.pop());
//        System.out.println(stack.peek());

        Deque<String> deque = new ArrayDeque<>();
        deque.push("salam");
        deque.push("necesen");
        deque.push("alam");
        deque.push("hello");//evellden elave edir
        deque.add("hi"); //axirdan elave edir

        System.out.println(deque.peek());
        System.out.println(deque.remove());

    }

}
