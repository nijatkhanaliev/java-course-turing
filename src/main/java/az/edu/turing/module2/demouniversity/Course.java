package az.edu.turing.module2.demouniversity;

import java.util.Arrays;

public class Course {
    private int courseCode;
    private String courseName;
    private Professor professor;
    private Student[] students;

    public Course(int courseCode, String courseName, Professor professor, int limit) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.professor = professor;
        this.students = new Student[limit];
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    private int count;

    public void addStudent(Student newStudent) {
        if (count >= students.length) {
            System.out.println("You can add " + students.length + " student");
            return;
        }

        for (Student student : students) {
            if (student != null) {
                if (student.getId() == newStudent.getId()) {
                    System.out.println("Student has already exists");
                    return;
                }
            } else {
                return;
            }
        }

        students[count] = newStudent;
        count++;
    }

    public double calculateCourseGpa() {
        double sum = 0;
        for (Student student : students) {
            if (student != null) {
                sum += student.calculateStudentGpa();
            } else {
                break;
            }
        }

        return (sum / students.length);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode=" + courseCode +
                ", courseName='" + courseName + '\'' +
                ", professor=" + professor +
                ", students=" + Arrays.toString(students) +
                '}';
    }
}
