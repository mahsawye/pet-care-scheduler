import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Appointment {

    private String appointmentType;
    private LocalDateTime dateTime;
    private String notes;

    // Date and time format
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    // Constructor
    public Appointment(String appointmentType, LocalDateTime dateTime, String notes) {
        this.appointmentType = appointmentType;
        this.dateTime = dateTime;
        this.notes = notes;
    }

    // Getter for appointment type
    public String getAppointmentType() {
        return appointmentType;
    }

    // Setter for appointment type
    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    // Getter for date and time
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    // Setter for date and time
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    // Getter for notes
    public String getNotes() {
        return notes;
    }

    // Setter for notes
    public void setNotes(String notes) {
        this.notes = notes;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Appointment Type: " + appointmentType
                + ", Date and Time: " + dateTime.format(FORMATTER)
                + ", Notes: " + (notes == null || notes.isEmpty() ? "None" : notes);
    }
}
