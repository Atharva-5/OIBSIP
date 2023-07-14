import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ReservationSystem {
    private static int pnrCounter = 100;
    private List<ReservationDetails> reservations;

    public ReservationSystem() {
        reservations = new ArrayList<>();
    }

    private String generatePNR() {
        return "PNR" + pnrCounter++;
    }

    public void makeReservation() {
        Scanner scanner = new Scanner(System.in);

        //  user details
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter train number: ");
        int trainNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline character
        System.out.print("Enter class type: ");
        String classType = scanner.nextLine();
        System.out.print("Enter date of journey: ");
        String dateOfJourney = scanner.nextLine();
        System.out.print("Enter source: ");
        String source = scanner.nextLine();
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();


        String pnr = generatePNR();
        ReservationDetails reservation = new ReservationDetails(pnr, name, trainNumber, classType, dateOfJourney, source, destination);
        reservations.add(reservation);

        // reservation details
        System.out.println("\nReservation Details");
        System.out.println("PNR: " + pnr);
        System.out.println("Name: " + name);
        System.out.println("Train Number: " + trainNumber);
        System.out.println("Class Type: " + classType);
        System.out.println("Date of Journey: " + dateOfJourney);
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
    }

    public void cancelReservation() {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter your PNR: ");
        String pnr = scanner.nextLine();


        boolean found = false;
        for (int i = 0; i < reservations.size(); i++) {
            ReservationDetails reservation = reservations.get(i);
            if (reservation.getPNR().equals(pnr)) {
                found = true;

                //  cancellation details
                System.out.println("\nCancellation Details for PNR: " + pnr);
                System.out.println("Name: " + reservation.getName());
                System.out.println("Train Number: " + reservation.getTrainNumber());
                System.out.println("Class Type: " + reservation.getClassType());
                System.out.println("Date of Journey: " + reservation.getDateOfJourney());
                System.out.println("Source: " + reservation.getSource());
                System.out.println("Destination: " + reservation.getDestination());

                System.out.print("Do you want to confirm the cancellation? (Y/N): ");
                String confirmation = scanner.nextLine();

                if (confirmation.equalsIgnoreCase("Y")) {

                    reservations.remove(i);
                    System.out.println("Your reservation has been cancelled.");
                } else {
                    System.out.println("Cancellation aborted.");
                }
                break;
            }
        }

        if (!found) {
            System.out.println("Invalid PNR. No reservation found.");
        }
    }
}

class ReservationDetails {
    private String pnr;
    private String name;
    private int trainNumber;
    private String classType;
    private String dateOfJourney;
    private String source;
    private String destination;

    public ReservationDetails(String pnr, String name, int trainNumber, String classType, String dateOfJourney, String source, String destination) {
        this.pnr = pnr;
        this.name = name;
        this.trainNumber = trainNumber;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.source = source;
        this.destination = destination;
    }

    public String getPNR() {
        return pnr;
    }

    public String getName() {
        return name;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getClassType() {
        return classType;
    }

    public String getDateOfJourney() {
        return dateOfJourney;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }
}

class OnlineReservation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationSystem reservationSystem = new ReservationSystem();

        // Login form
        System.out.print("Enter your login id: ");
        String loginId = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (authenticate(loginId, password)) {
            System.out.println("\nWelcome to the Online Reservation System!");

            boolean LoggedIn = true;
            while (LoggedIn) {
                System.out.println();
                System.out.println("1. Make a reservation");
                System.out.println("2. Cancel a reservation");
                System.out.println("3. Logout.");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        reservationSystem.makeReservation();
                        break;
                    case 2:
                        reservationSystem.cancelReservation();
                        break;
                    case 3:
                        LoggedIn = false;
                        System.out.println("Logged out successfully.");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } else {
            System.out.println("Invalid login credentials. Access denied.");
        }
    }
    private static boolean authenticate(String loginId, String password) {
        return loginId.equals("user123") && password.equals("password123");
    }
}
