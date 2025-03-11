package az.edu.turing.module2.demouniversity;

import java.util.Arrays;
import java.util.Objects;

public class Student extends Person {
    private String major;
    private Course[] courses;
    private double[] grades;

    public Student(String major,int limit) {
        this.major = major;
        this.courses = new Course[limit];
        this.grades = new double[limit];
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public double[] getGrades() {
        return grades;
    }

    public void setGrades(double[] grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                ", major='" + major + '\'' +
                ", courses=" + Arrays.toString(courses) +
                ", grades=" + Arrays.toString(grades) +
                '}';
    }
}
