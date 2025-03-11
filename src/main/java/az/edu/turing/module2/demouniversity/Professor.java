package az.edu.turing.module2.demouniversity;

import java.util.Arrays;

public class Professor extends Person {
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

    private int count;

    public void addSubject(String newSubject) {
        if (count >= subjects.length) {
            System.out.println("You can add " + subjects.length + " subject");
            return;
        }

        for (String subject : subjects) {
            if (subject != null) {
                if (subject.equalsIgnoreCase(newSubject)) {
                    System.out.println("Subject has already exists");
                    return;
                }
            } else {
                break;
            }
        }

        subjects[count] = newSubject;
        count++;
    }

    public String getSubjectList() {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (String subject : subjects) {
            if (subject != null) {
                if (count == subjects.length - 1) {
                    sb.append(subject);
                } else {
                    count++;
                    sb.append(subject).append(",");
                }
            } else {
                break;
            }
        }
        return sb.toString();
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
