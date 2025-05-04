package az.edu.turing.module3.hospitalmanagement.model;

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

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public Patient getPatient() {
        return patient;
    }

    public void assignPatient(Patient patient) {
        this.patient = patient;
    }

    public void clearRoom() {
        this.patient = null;
        this.isOccupied = false;
    }

    public Room fromString(String line, Patient patient) {
        String[] arr = line.split("\\|");
        int roomNumber = Integer.parseInt(arr[0].split("=")[1].trim());
        boolean isOccupied = Boolean.parseBoolean(arr[1].split("=")[1].trim());
        String patientId = null;
        if (isOccupied) {
            patientId = arr[2].split("=")[1].trim();
        }

        Room room = new Room(roomNumber);
        room.setOccupied(isOccupied);
        if (patient.getId().equalsIgnoreCase(patientId)) {
            room.assignPatient(patient);
        }

        return room;
    }

    @Override
    public String toString() {
        if (!isOccupied && patient == null) {
            return "roomNumber=" + roomNumber +
                    " | isOccupied=" + isOccupied +
                    " | ";
        }
        return "roomNumber=" + roomNumber +
                " | isOccupied=" + isOccupied +
                " | patientId=" + patient.getId();
    }
}
