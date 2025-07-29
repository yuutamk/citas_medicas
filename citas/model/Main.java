package org.example;

import java.util.Scanner;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataBaseConnection dbConnection = new DataBaseConnection();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create Appointment");
            System.out.println("2. Read Appointments");
            System.out.println("3. Update Appointment");
            System.out.println("4. Delete Appointment");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Doctor ID: ");
                    int doctorId = scanner.nextInt();
                    System.out.print("Enter Patient ID: ");
                    int patientId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Appointment Date (YYYY-MM-DD HH:MM:SS): ");
                    String appointmentDate = scanner.nextLine();
                    System.out.print("Enter Reason: ");
                    String reason = scanner.nextLine();
                    dbConnection.createAppointment(doctorId, patientId, appointmentDate, reason);
                }
                case 2 -> dbConnection.readAppointments();
                case 3 -> {
                    System.out.print("Enter Appointment ID to update: ");
                    int appointmentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter New Date (YYYY-MM-DD HH:MM:SS): ");
                    String newDate = scanner.nextLine();
                    System.out.print("Enter New Reason: ");
                    String newReason = scanner.nextLine();
                    dbConnection.updateAppointment(appointmentId, newDate, newReason);
                }
                case 4 -> {
                    System.out.print("Enter Appointment ID to delete: ");
                    int appointmentId = scanner.nextInt();
                    dbConnection.deleteAppointment(appointmentId);
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
