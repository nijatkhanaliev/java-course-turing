package az.edu.turing.module3.hospitalmanagement.model;

import java.time.LocalDate;

public class Patient extends Person {
    private String diagnosis;

    public Patient(String id, String name, LocalDate birthDate, String gender, String diagnosis) {
        super(id, name, birthDate, gender);
        this.diagnosis = diagnosis;
    }

    public static Patient fromString(String line){
        String[] arr = line.split("\\|");
        String id = arr[0].split("=")[1].trim();
        String name = arr[1].split("=")[1].trim();
        LocalDate birthDate = LocalDate.parse(arr[2].split("=")[1].trim());
        String gender = arr[3].split("=")[1].trim();
        String diagnosis = arr[4].split("=")[1].trim();


        return new Patient(id,name,birthDate,gender,diagnosis);
    }


    @Override
    public String getInfo() {
        return toString();
    }

    @Override
    public String toString() {
        return "id=" + id +
                " | name=" + name +
                " | birthDate=" + birthDate +
                " | gender=" + gender +
                " | diagnosis=" + diagnosis;
    }
}
