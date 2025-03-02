package az.edu.turing.module2.lesson01;

public class Student {
    public static int count;
    public String name;
    public int age;

    static {
        System.out.println("static block executed");
    }


    {
        System.out.println("instance block executed");
        this.name = "lisa";
        this.age = 18;
        count++;
    }

    public Student() {
        System.out.println("default constructor");
    }

    public Student(String name, int age) {
        this();
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
