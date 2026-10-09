# PetCare Scheduler

## Overview

PetCare Scheduler is a simple Java console-based application developed for Paws & Whiskers to manage pet registrations and appointments.

The application allows users to register pets, schedule appointments, view pet records, and generate basic reports. It also supports saving data to a file so that information can be loaded when the application runs again.

## Features

- **Pet Registration:** Register pets with their ID, name, species or breed, age, owner details, and registration date.
- **Appointment Scheduling:** Schedule vet visits, vaccinations, and grooming appointments.
- **Data Display:** View registered pets, appointments for a specific pet, upcoming appointments, and past appointment history.
- **Reports:** Identify pets with appointments in the next seven days and pets overdue for a vet visit.
- **Data Persistence:** Save and load pet and appointment records using file handling.
- **Input Validation:** Check pet IDs, ages, appointment types, and date/time formats.
- **Console Menu:** Navigate through the application using a simple menu.

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Java Collections Framework
- Java Date and Time API
- File I/O and Object Serialization
- Exception Handling

## Project Structure

```text
PetCareScheduler/
├── src/
│   ├── Pet.java
│   ├── Appointment.java
│   └── PetCareScheduler.java
├── README.md
└── .gitignore
```

## How to Run

Make sure the Java Development Kit (JDK) is installed.

1. Open a terminal in the project's root directory.
2. Compile the Java source files:

   ```bash
   javac -d out src/*.java
   ```

3. Run the application:

   ```bash
   java -cp out PetCareScheduler
   ```

The application saves pet and appointment data in `pets.dat` in the current working directory.

## Data Storage

Pet and appointment information is saved in a local file named `pets.dat`. The application loads previously saved records when it starts, provided the file exists.

Keep the data file in the application's working directory.

## Learning Objectives

This project demonstrates basic Java programming concepts, including:

- Classes and objects
- Encapsulation and getters/setters
- Collections and loops
- Switch statements
- User input with `Scanner`
- Date and time validation
- Exception handling
- Saving and loading objects from a file

## Future Improvements

- Add the ability to edit and delete pet records.
- Improve input validation and error messages.
- Sort appointments by date and time.
- Add a graphical user interface.
- Use a database instead of a local data file.

## Project Background

Completed as a guided learning project on Coursera to practice core Java programming concepts and object-oriented application development.

## Author

Developed as a Java programming course project.
