package az.edu.turing.module3.hospitalmanagement;

import az.edu.turing.module3.hospitalmanagement.manager.HospitalManager;
import az.edu.turing.module3.hospitalmanagement.model.Appointment;
import az.edu.turing.module3.hospitalmanagement.model.Doctor;
import az.edu.turing.module3.hospitalmanagement.model.Patient;
import az.edu.turing.module3.hospitalmanagement.model.Specialization;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        HospitalManager hospitalManager = new HospitalManager();

        Patient patient = new Patient("1","nicat", LocalDate.now(),"male","lung");
        Patient patient2 = new Patient("2","rasul", LocalDate.now(),"female","lung");
        Doctor doctor = new Doctor("1","nicat",LocalDate.now(),"male", Specialization.SURGEON,LocalDate.now());

        hospitalManager.add(doctor);
        hospitalManager.add(doctor);
        hospitalManager.add(doctor);


        System.out.println(HospitalManager.doctors.size());
    }
}
