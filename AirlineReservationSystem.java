import java.util.Scanner;

public class AirlineReservationSystem {
    private static boolean[] seats = new boolean[10];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to the Airline Reservation System");
            System.out.println("1. First Class");
            System.out.println("2. Economy Class");
            System.out.println("3. Seat Availability");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    reserveFirstClass();
                    break;
                case 2:
                    reserveEconomyClass();
                    break;
                case 3:
                    checkSeatAvailability();
                    break;
                case 4:
                    System.out.println("Thank you for using the Airline Reservation System");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void reserveFirstClass() {
        for (int seat = 0; seat < 5; seat++) {
            if (!seats[seat]) {
                seats[seat] = true;
                System.out.println("Your seat number is: " + (seat + 1));
                return;
            }
        }
        System.out.println("Sorry, all seats in First Class are taken.");
        askForAlternativeClass();
    }

    private static void reserveEconomyClass() {
        for (int seat = 5; seat < 10; seat++) {
            if (!seats[seat]) {
                seats[seat] = true;
                System.out.println("Your seat number is: " + (seat + 1));
                return;
            }
        }
        System.out.println("Sorry, all seats in Economy Class are taken.");
        askForAlternativeClass();
    }

    private static void askForAlternativeClass() {
        System.out.print("Would you like to be placed in the alternative class? (yes/no): ");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("yes")) {
            System.out.println("We have placed you in the alternative class.");
        } else if (choice.equalsIgnoreCase("no")) {
            System.out.println("Next flight leaves in 3 hours.");
        } else {
            System.out.println("Invalid choice. Please try again.");
            askForAlternativeClass();
        }
    }

    private static void checkSeatAvailability() {
        System.out.println("Seat Availability");
        System.out.println("First Class:");
        for (int seat = 0; seat < 5; seat++) {
            System.out.println("Seat " + (seat + 1) + ": " + (seats[seat] ? "Taken" : "Available"));
        }
        System.out.println("Economy Class:");
        for (int seat = 5; seat < 10; seat++) {
            System.out.println("Seat " + (seat + 1) + ": " + (seats[seat] ? "Taken" : "Available"));
        }
    }
}