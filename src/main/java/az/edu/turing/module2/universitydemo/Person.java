package az.edu.turing.module2.universitydemo;

import java.util.Objects;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public Person() {
    }

    public Person(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id<=0){
            System.out.println("Invalid id");
            return;
        }
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    public void setAge(int age) {
        if(age<17){
            System.out.println("Age must be more than 17");
            return;
        }
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && age == person.age && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age);
    }

    @Override
    public String toString() {
        return "id=" + this.id +
                ", firstName=" + this.firstName +
                ", lastName=" + this.lastName +
                ", age=" + this.age;
    }

}
