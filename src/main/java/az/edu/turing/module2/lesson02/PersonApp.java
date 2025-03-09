package az.edu.turing.module2.lesson02;

import java.util.Random;

public class PersonApp {

    public static void main(String[] args) {

        Student student1 = new Student(1,"nicat",20,97.6);
        Student student2 = new Student(2,"ali",26,97.4);
        Teacher teacher = new Teacher(1,"tale",28,"java");

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(teacher);

    }

}
