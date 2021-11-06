public class Seat {
   private String firstName;
   private String lastName;
   private int amountPaid;

   // Method to initialize Seat fields
   public void reserve(String first, String last, int reservationPaid) {
      firstName = first;
      lastName = last;
      amountPaid = reservationPaid;
   }

   // Method to empty a Seat
   public void makeEmpty() {
      firstName = "empty";
      lastName = "empty";
      amountPaid = 0;
   }

   // Method to check if Seat is empty
   public boolean isEmpty() {
      return firstName.equals("empty");
   }

   // Method to print Seat fields
   public void print() {
      System.out.print(firstName + " " + lastName + " ");
      System.out.println("Paid: " + amountPaid);
   }
   
   public String getFirstName() {
      return firstName;
   }
   
   public String getLastName() {
      return lastName;
   }
   
   public int getAmountPaid() {
      return amountPaid;
   }
}