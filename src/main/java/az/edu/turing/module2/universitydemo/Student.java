package az.edu.turing.module2.universitydemo;

import java.util.Arrays;
import java.util.Objects;

public class Student extends Person{
    private double gpa;
    private Course[] courses;

    public Student(){

    }

    public Student(int id, String firstName, String lastName, int age, double gpa, Course[] courses) {
        super(id, firstName, lastName, age);
        this.gpa = gpa;
        this.courses = courses;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Double.compare(gpa, student.gpa) == 0 && Objects.deepEquals(courses, student.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gpa, Arrays.hashCode(courses));
    }

    @Override
    public String toString(){
        return super.toString() +
                ", gpa=" + gpa +
                ", courses=" + courses.toString();
    }

}
