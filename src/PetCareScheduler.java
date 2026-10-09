import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PetCareScheduler {

    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Pet> pets = new HashMap<>();

    private static final String FILE_NAME = "pets.dat";
    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATE_TIME_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static void main(String[] args) {

        loadData();

        boolean running = true;

        while (running) {
            System.out.println("\n--- PetCare Scheduler ---");
            System.out.println("1. Register Pet");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. Display Records");
            System.out.println("4. Generate Reports");
            System.out.println("5. Save Data");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        registerPet();
                        break;
                    case 2:
                        scheduleAppointment();
                        break;
                    case 3:
                        displayRecords();
                        break;
                    case 4:
                        generateReports();
                        break;
                    case 5:
                        saveData();
                        break;
                    case 6:
                        saveData();
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    // Register a new pet
    private static void registerPet() {

        System.out.print("Pet ID: ");
        String id = scanner.nextLine();

        if (pets.containsKey(id)) {
            System.out.println("Pet ID already exists.");
            return;
        }

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Species/Breed: ");
        String breed = scanner.nextLine();

        System.out.print("Age: ");

        int age;
        try {
            age = Integer.parseInt(scanner.nextLine());

            if (age < 0) {
                System.out.println("Age cannot be negative.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid age.");
            return;
        }

        System.out.print("Owner name: ");
        String owner = scanner.nextLine();

        System.out.print("Contact info: ");
        String contact = scanner.nextLine();

        System.out.print("Registration date (yyyy-MM-dd): ");

        LocalDate registrationDate;

        try {
            registrationDate = LocalDate.parse(
                    scanner.nextLine(), DATE_FORMAT);
        } catch (Exception e) {
            System.out.println("Invalid date.");
            return;
        }

        Pet pet = new Pet(
                id, name, breed, age,
                owner, contact, registrationDate);

        pets.put(id, pet);

        System.out.println("Pet registered successfully.");
    }

    // Schedule an appointment
    private static void scheduleAppointment() {

        System.out.print("Enter Pet ID: ");
        String id = scanner.nextLine();

        Pet pet = pets.get(id);

        if (pet == null) {
            System.out.println("Pet not found.");
            return;
        }

        System.out.print(
                "Appointment type (Vet Visit/Vaccination/Grooming): ");
        String type = scanner.nextLine();

        if (!type.equalsIgnoreCase("Vet Visit")
                && !type.equalsIgnoreCase("Vaccination")
                && !type.equalsIgnoreCase("Grooming")) {

            System.out.println("Invalid appointment type.");
            return;
        }

        System.out.print(
                "Date and time (yyyy-MM-dd HH:mm): ");

        LocalDateTime dateTime;

        try {
            dateTime = LocalDateTime.parse(
                    scanner.nextLine(), DATE_TIME_FORMAT);
        } catch (Exception e) {
            System.out.println("Invalid date/time.");
            return;
        }

        if (!dateTime.isAfter(LocalDateTime.now())) {
            System.out.println(
                    "Appointment must be in the future.");
            return;
        }

        System.out.print("Notes: ");
        String notes = scanner.nextLine();

        Appointment appointment =
                new Appointment(type, dateTime, notes);

        pet.addAppointment(appointment);

        System.out.println("Appointment scheduled successfully.");
    }

    // Display records
    private static void displayRecords() {

        for (Pet pet : pets.values()) {

            System.out.println("\n" + pet);

            if (pet.getAppointments().isEmpty()) {
                System.out.println("No appointments.");
            } else {
                for (Appointment appointment :
                        pet.getAppointments()) {

                    System.out.println(appointment);
                }
            }
        }
    }

    // Generate simple reports
    private static void generateReports() {

        LocalDateTime now = LocalDateTime.now();

        System.out.println("\n--- Upcoming Appointments ---");

        for (Pet pet : pets.values()) {
            for (Appointment appointment :
                    pet.getAppointments()) {

                if (appointment.getDateTime().isAfter(now)
                        && appointment.getDateTime()
                        .isBefore(now.plusDays(7))) {

                    System.out.println(
                            pet.getName() + ": " + appointment);
                }
            }
        }

        System.out.println("\n--- Pets Overdue for Vet Visit ---");

        LocalDateTime sixMonthsAgo =
                now.minusMonths(6);

        for (Pet pet : pets.values()) {

            boolean vetVisitFound = false;

            for (Appointment appointment :
                    pet.getAppointments()) {

                if (appointment.getAppointmentType()
                        .equalsIgnoreCase("Vet Visit")
                        && appointment.getDateTime()
                        .isAfter(sixMonthsAgo)
                        && appointment.getDateTime()
                        .isBefore(now)) {

                    vetVisitFound = true;
                }
            }

            if (!vetVisitFound) {
                System.out.println(pet.getName());
            }
        }
    }

    // Save data to a file
    private static void saveData() {

        try (ObjectOutputStream output =
                     new ObjectOutputStream(
                             new FileOutputStream(FILE_NAME))) {

            output.writeObject(pets);
            System.out.println("Data saved.");

        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    // Load existing data
    private static void loadData() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (ObjectInputStream input =
                     new ObjectInputStream(
                             new FileInputStream(FILE_NAME))) {

            pets = (Map<String, Pet>) input.readObject();

        } catch (Exception e) {
            System.out.println("Could not load saved data.");
        }
    }
}
