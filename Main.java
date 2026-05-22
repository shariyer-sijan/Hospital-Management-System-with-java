import java.util.*;

abstract class User {
    protected int id;
    protected String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    abstract void showInfo();
}

class Patient extends User {

    private String disease;

    public Patient(int id, String name, String disease) {
        super(id, name);
        this.disease = disease;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    @Override
    void showInfo() {
        System.out.println("Patient ID: " + id);
        System.out.println("Patient Name: " + name);
        System.out.println("Disease: " + disease);
    }
}


class Doctor extends User {

    private String specialization;

    public Doctor(int id, String name, String specialization) {
        super(id, name);
        this.specialization = specialization;
    }

    @Override
    void showInfo() {
        System.out.println("Doctor ID: " + id);
        System.out.println("Doctor Name: " + name);
        System.out.println("Specialization: " + specialization);
    }
}

class Staff extends User {

    private String role;

    public Staff(int id, String name, String role) {
        super(id, name);
        this.role = role;
    }

    @Override
    void showInfo() {
        System.out.println("Staff ID: " + id);
        System.out.println("Staff Name: " + name);
        System.out.println("Role: " + role);
    }
}


class Bill {
    double calculateBill() {
        return 0;
    }
}

class GeneralWard extends Bill {
    double calculateBill() {
        return 1000;
    }
}

class ICUWard extends Bill {
    double calculateBill() {
        return 5000;
    }
}

class EmergencyWard extends Bill {
    double calculateBill() {
        return 3000;
    }
}

class Appointment {
    private String patientName;
    private String doctorName;
    private String date;

    public Appointment(String patientName, String doctorName, String date) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
    }

    void showAppointment() {
        System.out.println("Appointment:");
        System.out.println("Patient: " + patientName);
        System.out.println("Doctor: " + doctorName);
        System.out.println("Date: " + date);
    }
}

public class Main {

    public static void main(String[] args) {


        Patient p1 = new Patient(101, "Sijan", "Fever");


        Doctor d1 = new Doctor(2, "Awal", "Cardiologist");
        Doctor d2 = new Doctor(1, "Zisan", "Neurologist");

        Staff s1 = new Staff(1011, "Towfiq", "Receptionist");

        System.out.println("\n----- Patient Info -----");
        p1.showInfo();

        System.out.println("\n----- Doctor Info -----");
        d1.showInfo();
        d2.showInfo();

        System.out.println("\n----- Staff Info -----");
        s1.showInfo();

        Appointment a1 = new Appointment("Sijan", "Awal", "25 May 2026");

        System.out.println("\n----- Appointment -----");
        a1.showAppointment();

        Bill b1 = new GeneralWard();
        Bill b2 = new ICUWard();
        Bill b3 = new EmergencyWard();

        System.out.println("\n----- Bills -----");
        System.out.println("General Ward Bill: " + b1.calculateBill() + " TK");
        System.out.println("ICU Ward Bill: " + b2.calculateBill() + " TK");
        System.out.println("Emergency Ward Bill: " + b3.calculateBill() + " TK");
    }
}
