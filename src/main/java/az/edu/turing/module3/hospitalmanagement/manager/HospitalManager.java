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
            String line = inputStream.readLine();
            while (line != null) {
                Patient patient = Patient.fromString(line);
                patients.add(patient);

                line = inputStream.readLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return patients;
    }

    public void listAllDoctors() {
        doctors.forEach(System.out::println);
    }

    public void saveDoctorsToFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath, true);
             BufferedWriter bf = new BufferedWriter(writer)) {
            doctors.forEach(b -> {
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

    public List<Doctor> loadDoctorsFromFile(String filePath) {
        List<Doctor> doctors = new ArrayList<>();

        try (BufferedReader inputStream = new BufferedReader(new FileReader(filePath))) {
            String line = inputStream.readLine();
            while (line != null) {
                Doctor doctor = Doctor.fromString(line);
                doctors.add(doctor);

                line = inputStream.readLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return doctors;
    }

    public void listAllAppointments() {
        appointments.forEach(System.out::println);
    }

    public void saveAppointmentsToFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath, true);
             BufferedWriter bf = new BufferedWriter(writer)) {
            appointments.forEach(b -> {
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

    public List<Appointment> loadAppointmentsFromFile(String filePath) {
        List<Appointment> appointments = new ArrayList<>();

        try (BufferedReader inputStream = new BufferedReader(new FileReader(filePath))) {
            String line = inputStream.readLine();
            while (line != null) {
                Appointment appointment = Appointment.fromString(line);
                appointments.add(appointment);

                line = inputStream.readLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return appointments;
    }

    public void listAllAvailableRoom() {
        HospitalManager.rooms.stream().filter((r) -> !r.isOccupied()).forEach(System.out::println);
    }

    public Room addRoom(int roomNumber) {
        return new Room(roomNumber);
    }

    public void assignRoomToPatient(int roomNumber, Patient patient) {
        if (rooms.stream().anyMatch((r) -> r.getRoomNumber() == roomNumber)) {
            rooms.stream().filter((r) -> r.getRoomNumber() == roomNumber).findFirst().get().assignPatient(patient);
        }
    }

    public void saveRoomsToFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath, true);
             BufferedWriter bf = new BufferedWriter(writer)) {
            rooms.forEach(b -> {
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

    public List<Room> loadRoomsFromFile(String filePath) {
        List<Room> rooms = new ArrayList<>();

        try (BufferedReader inputStream = new BufferedReader(new FileReader(filePath))) {
            String line = inputStream.readLine();
            while (line != null) {
                Room room = Room.fromString(line,patients.getFirst());
                rooms.add(room);

                line = inputStream.readLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return rooms;
    }

    public void add(Object t) {
        if (t instanceof Doctor) {
            Doctor doctor = (Doctor) t;
            if (doctors.stream().anyMatch((d) -> d.getId().equals(doctor.getId()))) {
                System.out.println("Doctor already exists");
                return;
            }
            doctors.add(doctor);
        } else if (t instanceof Appointment) {
            Appointment appointment = (Appointment) t;
            if (appointments.stream().anyMatch((a) -> a.getId().equals(appointment.getId()))) {
                System.out.println("Appointment already exists");
                return;
            }
            appointments.add(appointment);
        } else if (t instanceof Patient) {
            Patient patient = (Patient) t;
            if (patients.stream().anyMatch((p) -> p.getId().equals(patient.getId()))) {
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
        } else {
            System.out.println("Object type is not correct");
        }
    }

}
