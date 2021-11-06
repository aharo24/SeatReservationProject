import java.util.ArrayList;
import java.util.Scanner;

public class SeatReservation {

   // Arraylist for seat reservations
   private final ArrayList<Seat> allSeats;

   public SeatReservation() {
      allSeats = new ArrayList<>();
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

   public void deleteSeat(int seatNum) {
      allSeats.remove(seatNum);
   }

   public Seat getSeat(int seatNum) {
      return allSeats.get(seatNum);
   }

   public void setSeat(int seatNum, Seat newSeat) {
      allSeats.set(seatNum, newSeat);
   }

   public void makeSeatReservations(Scanner scnr) {
      String firstName, lastName;
      int amountPaid;
      Seat newSeat;
      int seatNum;
      System.out.print("Enter seat num: ");
      seatNum = scnr.nextInt();

      if (!(this.getSeat(seatNum).isEmpty())) {
         System.out.println("Seat not empty.");
      } else {
         System.out.print("Enter first name: ");
         firstName = scnr.next();
         System.out.print("Enter last name: ");
         lastName = scnr.next();
         System.out.print("Enter amount paid: ");
         amountPaid = scnr.nextInt();

// Create new Seat object and add to the reservations
         newSeat = new Seat();
         newSeat.reserve(firstName, lastName, amountPaid);
         this.setSeat(seatNum, newSeat);
         System.out.println("Completed.");
      }
   }

   public void deleteSeatReservations(Scanner scnr) {
      int seatNum;
      System.out.print("Enter seat num: ");
      seatNum = scnr.nextInt();

      if (this.getSeat(seatNum).isEmpty()) {
         System.out.println("Seat is empty.");
      } else {
         Seat unreservedSeats;
         unreservedSeats= this.getSeat(seatNum);
         unreservedSeats.makeEmpty();
         this.setSeat(seatNum, unreservedSeats);
      }
   }
}