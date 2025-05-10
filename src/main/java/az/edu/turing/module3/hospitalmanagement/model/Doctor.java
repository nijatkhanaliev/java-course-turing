package az.edu.turing.module3.hospitalmanagement.model;

import javax.print.Doc;
import java.time.LocalDate;

public class Doctor extends Person{
    private Specialization specialization;
    private LocalDate employmentDate;

    public Doctor(String id, String name, LocalDate birthDate, String gender, Specialization specialization, LocalDate employmentDate) {
        super(id, name, birthDate, gender);
        this.specialization = specialization;
        this.employmentDate = employmentDate;
    }

    public static Doctor fromString(String line){
        String[] arr = line.split("\\|");
        String id = arr[0].split("=")[1].trim();
        String name = arr[1].split("=")[1].trim();
        LocalDate birthDate = LocalDate.parse(arr[2].split("=")[1].trim());
        String gender = arr[3].split("=")[1].trim();
        Specialization specialization = Specialization.valueOf(arr[4].split("=")[1].trim());
        LocalDate employmentDate = LocalDate.parse(arr[5].split("=")[1].trim());

        return new Doctor(id,name,birthDate,gender,specialization,employmentDate);
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
                " | specialization=" + specialization +
                " | employmentDate=" + employmentDate;
    }
}
