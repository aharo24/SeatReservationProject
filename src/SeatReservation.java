import java.util.ArrayList;
import java.util.Scanner;

public class SeatReservation {

   // Arraylist for seat reservations
   private ArrayList<Seat> allSeats;
   
   public SeatReservation() {
       allSeats = new ArrayList<Seat>();
   }
   
   public void makeSeatsEmpty() {
      int i;
      for (i = 0; i < allSeats.size(); ++i) {
         allSeats.get(i).makeEmpty();
      }
   }

   public void printSeats() {
      int i;
      for (i = 0; i < allSeats.size(); ++i) {
         System.out.print(i + ": ");
         allSeats.get(i).print();
      }
   }

   public void addSeats(int numSeats) {
      int i;
      for (i = 0; i < numSeats; ++i) {
         allSeats.add(new Seat());
      }
   }
   
   public Seat getSeat(int seatNum) {
      return allSeats.get(seatNum);
   }   
   
   public void setSeat(int seatNum, Seat newSeat) {
      allSeats.set(seatNum, newSeat); 
   }

   // Main method to use SeatReservation methods
   public static void main (String [] args) {
      Scanner scnr = new Scanner(System.in);
      String usrInput = "";
      String firstName, lastName;
      int amountPaid;
      int seatNum;
      Seat newSeat;
      SeatReservation ezReservations = new SeatReservation();

      // Add 5 seat objects
      ezReservations.addSeats(5);

      // Make all seats empty
      ezReservations.makeSeatsEmpty();

      while (!usrInput.equals("q")) {
         System.out.println();
         System.out.print("Enter command (p/r/q): ");
         usrInput = scnr.next();

         // Print seats
         if (usrInput.equals("p")) { 
            ezReservations.printSeats();
         }
         
         // Reserve a seat
         else if (usrInput.equals("r")) {
            System.out.print("Enter seat num: ");
            seatNum = scnr.nextInt();

            if ( !(ezReservations.getSeat(seatNum).isEmpty()) ) {
               System.out.println("Seat not empty.");
            }
            else {
               System.out.print("Enter first name: ");
               firstName = scnr.next();
               System.out.print("Enter last name: ");
               lastName = scnr.next();
               System.out.print("Enter amount paid: ");
               amountPaid = scnr.nextInt();

               // Create new Seat object and add to the reservations
               newSeat = new Seat();
               newSeat.reserve(firstName, lastName, amountPaid); 
               ezReservations.setSeat(seatNum, newSeat); 

               System.out.println("Completed.");
            }
         }
         // FIXME: Add option to delete reservations
         else if (usrInput.equals("q")) { // Quit
            System.out.println("Quitting.");
         }
         else {
            System.out.println("Invalid command.");
         }
      }
   }
}