import java.util.Scanner;

public class BaseClass
{
    // Main method to use SeatReservation methods
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        String usrInput = "";

        SeatReservation ezReservations = new SeatReservation();

// Add 5 seat objects
        ezReservations.addSeats(5);

// Make all seats empty
        ezReservations.makeSeatsEmpty();

        while (!usrInput.equals("q")) {
            System.out.println();
            System.out.print("Enter command (p/r/d/q): ");
            usrInput = sc.next();

// Print seats
            switch (usrInput) {
                case "p" -> ezReservations.printSeats();


// Reserve a seat
                case "r" -> ezReservations.makeSeatReservations(sc);

// Delete a reservation
                case "d" -> ezReservations.deleteSeatReservations(sc);
                case "q" ->  // Quit
                        System.out.println("Quitting.");
                default -> System.out.println("Invalid command.");
            }
        }
    }
}
