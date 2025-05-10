package az.edu.turing.module3.hospitalmanagement;

import az.edu.turing.module3.hospitalmanagement.manager.HospitalManager;
import az.edu.turing.module3.hospitalmanagement.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HospitalManager hospitalManager = new HospitalManager();

        Patient patient = new Patient("1","nicat", LocalDate.now(),"male","lung");
        Patient patient2 = new Patient("2","rasul", LocalDate.now(),"male","lung");
        Doctor doctor = new Doctor("1","nicat",LocalDate.now(),"male", Specialization.SURGEON,LocalDate.now());
        Doctor doctor1 = new Doctor("2","rasul",LocalDate.now(),"male", Specialization.CARDIOLOGIST,LocalDate.now());
        Room room1 = new Room(1);
        Room room2 = new Room(2);
        room1.assignPatient(patient);
        room2.assignPatient(patient2);

        Appointment appointment = new Appointment("1",patient2,doctor, LocalDateTime.now(),"lung");

        hospitalManager.add(doctor);
        hospitalManager.add(doctor1);
        hospitalManager.add(patient);
        hospitalManager.add(patient2);
        hospitalManager.add(room1);
        hospitalManager.add(room2);
        hospitalManager.add(appointment);


        hospitalManager.savePatientsToFile("data/patients.txt");
        hospitalManager.saveAppointmentsToFile("data/appointments.txt");
        hospitalManager.saveDoctorsToFile("data/doctors.txt");
        hospitalManager.saveRoomsToFile("data/rooms.txt");

        List<Doctor> doctors = hospitalManager.loadDoctorsFromFile("data/doctors.txt");
        List<Patient> patients = hospitalManager.loadPatientsFromFile("data/patients.txt");
        List<Appointment> appointments = hospitalManager.loadAppointmentsFromFile("data/appointments.txt");
        List<Room> rooms = hospitalManager.loadRoomsFromFile("data/rooms.txt");

        doctors.forEach(System.out::println);
        patients.forEach(System.out::println);
        appointments.forEach(System.out::println);
        rooms.forEach(System.out::println);
    }
}
