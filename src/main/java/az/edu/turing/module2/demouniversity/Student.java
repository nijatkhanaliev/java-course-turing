package az.edu.turing.module2.demouniversity;

import java.util.Arrays;

public class Student extends Person {
    private String major;
    private Course[] courses;
    private double[] grades;

    public Student(String major, int limit) {
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

    private int count;

    public void enrollCourse(Course course) {
        if (count >= courses.length) {
            System.out.println("You can add " + courses.length + " course");
            return;
        }

        for (Course cr : courses) {
            if (cr != null) {
                if (cr.getCourseCode() == course.getCourseCode()) {
                    System.out.println("Course has already enrolled ");
                    return;
                }
            } else {
                break;
            }
        }

        courses[count] = course;
        count++;
    }

    public void updateGrade(int courseCode, double newGrade) {
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] != null) {
                if (courses[i].getCourseCode() == courseCode) {
                    grades[i] = newGrade;
                    return;
                }
            } else {
                break;
            }
        }

        System.out.println("Course does not exists");
    }

    public void updateGrade(String courseName, double newGrade) {
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] != null) {
                if (courses[i].getCourseName().equalsIgnoreCase(courseName)) {
                    grades[i] = newGrade;
                    return;
                }
            } else {
                break;
            }
        }

        System.out.println("Course does not exists");
    }

    public double calculateStudentGpa() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }

        return (sum / grades.length);
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
