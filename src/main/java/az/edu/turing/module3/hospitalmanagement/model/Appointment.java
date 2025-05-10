package az.edu.turing.module3.hospitalmanagement.model;

import az.edu.turing.module3.hospitalmanagement.manager.HospitalManager;

import java.time.LocalDateTime;

public class Appointment {
    private String id;
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime dateTime;
    private String note;

    public Appointment(String id, Patient patient, Doctor doctor, LocalDateTime dateTime, String note) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = dateTime;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public static Appointment fromString(String line){
        String[] arr = line.split("\\|");
        String id = arr[0].split("=")[1].trim();
        String patientId = arr[1].split("=")[1].trim();
        String doctorId = arr[2].split("=")[1].trim();
        LocalDateTime dateTime = LocalDateTime.parse(arr[3].split("=")[1].trim());
        String note = arr[4].split("=")[1].trim();

        Patient patient = HospitalManager.patients.stream().filter((p)->p.getId().equals(patientId)).findFirst().get();
        Doctor doctor = HospitalManager.doctors.stream().filter((d)->d.getId().equalsIgnoreCase(doctorId)).findFirst().get();

        return new Appointment(id,patient,doctor,dateTime,note);
    }

    @Override
    public String toString() {
        return "id=" + id +
                " | PatientId=" + patient.getId() +
                " | DoctorId=" + doctor.getId() +
                " | DateTime=" + dateTime +
                " | note=" + note;
    }
}
