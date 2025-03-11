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

    private int personCount;

    public void addPerson(Person newPerson) {
        for (Person person : people) {
            if (person.getId() == newPerson.getId()) {
                System.out.println("Person has already exists");
                return;
            }
        }

        people[personCount] = newPerson;
        personCount++;
    }

    private int courseCount;

    public void addCourse(Course newCourse) {
        if (courseCount >= courses.length) {
            System.out.println("You can add " + courses.length + " course");
            return;
        }

        for (Course course : courses) {
            if (course.getCourseCode() == newCourse.getCourseCode()) {
                System.out.println("Course has already exists");
                return;
            }
        }
        courses[courseCount] = newCourse;
        courseCount++;
    }

    public void displayAllPeople() {
        for (Person person : people) {
            System.out.println(person);
        }
    }

    public Person searchPersonById(int id) {
        for (Person person : people) {
            if (person.getId() == id) {
                return person;
            }
        }

        System.out.println("Person not found");
        return null;
    }

    public Course searchByCourseCode(int courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode() == courseCode) {
                return course;
            }
        }

        System.out.println("Course not found");
        return null;
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
