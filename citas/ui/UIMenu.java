package ui;

import java.util.Scanner;

public class UIMenu {

    public static String[] MONTHS = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    public static void showMenu() {
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        Scanner sc = new Scanner(System.in);
        int response;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            response = Integer.parseInt(sc.nextLine());

            switch (response) {
                case 1 -> showDoctorMenu();
                case 2 -> showPatientMenu();
                case 0 -> System.out.println("Thank you for your visit");
                default -> System.out.println("Please select a correct answer");
            }
        } while (response != 0);
    }

    public static void showDoctorMenu() {
        Scanner sc = new Scanner(System.in);
        int response;
        do {
            System.out.println("\n\nDoctor Menu");
            System.out.println("1. View appointments");
            System.out.println("2. Reject an appointment");
            System.out.println("3. Mark appointment as attended");
            System.out.println("4. Reschedule an appointment");
            System.out.println("0. Return");

            response = Integer.parseInt(sc.nextLine());

            switch (response) {
                case 1 -> System.out.println("::View appointments");
                case 2 -> System.out.println("::Reject an appointment");
                case 3 -> System.out.println("::Mark appointment as attended");
                case 4 -> System.out.println("::Reschedule an appointment");
                case 0 -> showMenu();
                default -> System.out.println("Please select a correct answer");
            }
        } while (response != 0);
    }

    static void showPatientMenu() {
        Scanner sc = new Scanner(System.in);
        int response;
        do {
            System.out.println("\n\nPatient Menu");
            System.out.println("1. Book an appointment");
            System.out.println("2. View my appointments");
            System.out.println("0. Return");

            response = Integer.parseInt(sc.nextLine());

            switch (response) {
                case 1 -> System.out.println("::Book an appointment");
                case 2 -> System.out.println("::View my appointments");
                case 0 -> showMenu();
                default -> System.out.println("Please select a correct answer");
            }
        } while (response != 0);
    }
}