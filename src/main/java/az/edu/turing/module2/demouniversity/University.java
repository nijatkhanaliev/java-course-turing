package az.edu.turing.module2.demouniversity;

import java.util.Arrays;

public class University {
    private String name;
    private Person[] people;
    private Course[] courses;

    public University(String name, int peopleLimit, int coursesLimit) {
        this.name = name;
        this.people = new Person[peopleLimit];
        this.courses = new Course[coursesLimit];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person[] getPeople() {
        return people;
    }

    public void setPeople(Person[] people) {
        this.people = people;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", people=" + Arrays.toString(people) +
                ", courses=" + Arrays.toString(courses) +
                '}';
    }
}
