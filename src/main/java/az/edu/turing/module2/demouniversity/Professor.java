package az.edu.turing.module2.demouniversity;

import java.util.Arrays;

public class Professor extends Person{
    private String department;
    private String[] subjects;

    public Professor(String department, int limit) {
        this.department = department;
        this.subjects = new String[limit];
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Professor{" +
                super.toString() +
                ", department='" + department + '\'' +
                ", subjects=" + Arrays.toString(subjects) +
                '}';
    }
}
