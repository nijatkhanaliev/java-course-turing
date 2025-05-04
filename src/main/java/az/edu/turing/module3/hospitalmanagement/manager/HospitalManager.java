package az.edu.turing.module3.hospitalmanagement.manager;

import az.edu.turing.module3.hospitalmanagement.model.Appointment;
import az.edu.turing.module3.hospitalmanagement.model.Doctor;
import az.edu.turing.module3.hospitalmanagement.model.Patient;
import az.edu.turing.module3.hospitalmanagement.model.Room;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalManager {
    public static List<Patient> patients = new ArrayList<>();
    public static List<Doctor> doctors = new ArrayList<>();
    public static List<Appointment> appointments = new ArrayList<>();
    public static List<Room> rooms = new ArrayList<>();


    public void listAllPatients() {
        patients.forEach(System.out::println);
    }

    public void savePatientsToFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath, true);
             BufferedWriter bf = new BufferedWriter(writer)) {
            patients.forEach(b -> {
                try {
                    bf.write(b.toString() + "\n");
                } catch (IOException e) {
                    System.out.println("write to file" + e.getMessage());
                }
            });

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Patient> loadPatientsFromFile(String filePath) {
        List<Patient> patients = new ArrayList<>();

        try (BufferedReader inputStream = new BufferedReader(new FileReader(filePath))) {
            System.out.println(inputStream.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return patients;
    }

    public void add(Object t) {
        if (t instanceof Doctor) {
            Doctor doctor = (Doctor) t;
            if (doctors.stream().anyMatch((d) -> d.getId().equalsIgnoreCase(doctor.getId()))) {
                System.out.println("Doctor already exists");
                return;
            }
            doctors.add(doctor);
        } else if (t instanceof Appointment) {
            Appointment appointment = (Appointment) t;
            if (appointments.stream().anyMatch((a) -> a.getId().equalsIgnoreCase(appointment.getId()))) {
                System.out.println("Appointment already exists");
                return;
            }
            appointments.add(appointment);
        } else if (t instanceof Patient) {
            Patient patient = (Patient) t;
            if (patients.stream().anyMatch((p) -> p.getId().equalsIgnoreCase(patient.getId()))) {
                System.out.println("Patient already exists");
                return;
            }
            patients.add(patient);
        } else if (t instanceof Room) {
            Room room = (Room) t;
            if (rooms.stream().anyMatch((r) -> r.getRoomNumber() == room.getRoomNumber() && r.isOccupied())) {
                System.out.println("This room is already occupied with roomNumber: " + room.getRoomNumber());
                return;
            }
            rooms.add(room);
        }
    }

}
