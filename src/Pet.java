import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pet {

    private String petId;
    private String name;
    private String speciesBreed;
    private int age;
    private String ownerName;
    private String contactInfo;
    private LocalDate registrationDate;
    private List<Appointment> appointments;

    // Constructor
    public Pet(String petId, String name, String speciesBreed, int age,
               String ownerName, String contactInfo, LocalDate registrationDate) {

        this.petId = petId;
        this.name = name;
        this.speciesBreed = speciesBreed;
        this.age = age;
        this.ownerName = ownerName;
        this.contactInfo = contactInfo;
        this.registrationDate = registrationDate;
        this.appointments = new ArrayList<>();
    }

    // Getter and setter for Pet ID
    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    // Getter and setter for Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for Species/Breed
    public String getSpeciesBreed() {
        return speciesBreed;
    }

    public void setSpeciesBreed(String speciesBreed) {
        this.speciesBreed = speciesBreed;
    }

    // Getter and setter for Age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getter and setter for Owner Name
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    // Getter and setter for Contact Info
    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    // Getter and setter for Registration Date
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    // Getter for appointments
    public List<Appointment> getAppointments() {
        return appointments;
    }

    // Add an appointment
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }
}
