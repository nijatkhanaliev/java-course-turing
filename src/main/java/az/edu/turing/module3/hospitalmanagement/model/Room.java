package az.edu.turing.module3.hospitalmanagement.model;

import az.edu.turing.module3.hospitalmanagement.manager.HospitalManager;

public class Room {
    private int roomNumber;
    private boolean isOccupied;
    private Patient patient;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }


    public Patient getPatient() {
        return patient;
    }

    public void assignPatient(Patient patient) {
        if (this.patient != null) {
            System.out.println("it already occupied");
            return;
        }

        if(patient==null){
            clearRoom();
            return;
        }

        this.patient = patient;
        this.isOccupied = true;
    }


    public void clearRoom() {
        this.patient = null;
        this.isOccupied = false;
    }

    public static Room fromString(String line,Patient patient) {
        String[] arr = line.split("\\|");
        int roomNumber = Integer.parseInt(arr[0].split("=")[1].trim());
        boolean isOccupied = Boolean.parseBoolean(arr[1].split("=")[1].trim());
        String patientId;
        if (isOccupied) {
            patientId = arr[2].split("=")[1].trim();
        } else {
            patientId = null;
        }

        Room room = new Room(roomNumber);
        if(patientId==null){
            room.assignPatient(null);
        }else if(!patient.getId().equals(patientId)){
           Patient patient1 = HospitalManager.patients.stream().filter((p)->p.getId().equals(patientId)).findFirst().get();
           room.assignPatient(patient1);
        }else{
            room.assignPatient(patient);
        }

        return room;
    }

    @Override
    public String toString() {
        if (!isOccupied && patient == null) {
            return "roomNumber=" + roomNumber +
                    " | isOccupied=" + isOccupied;
        }
        return "roomNumber=" + roomNumber +
                " | isOccupied=" + isOccupied +
                " | patientId=" + patient.getId();
    }
}
