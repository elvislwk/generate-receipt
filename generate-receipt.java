import java.util.Scanner;
public class generateReceipt {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      displayList();
      int code;
      int quantity;
      String description;
      do {
         System.out.print("Enter item code: ");
         code = input.nextInt();
         System.out.print("Enter quantity: ");
         quantity = input.nextInt();
         description = getItem(code);
         if (code < 1101 || code > 1105) {
            System.out.println(description);
         }
      }
      while (code < 1101 || code > 1105);
      int price = getPrice(code);
      double totalwithoutgst = price*quantity;
      double gst = calculateGST(totalwithoutgst);
      double totalcost = calculateTotal(totalwithoutgst, gst);
      displayTotal(code, description, price, quantity, totalcost, gst, totalwithoutgst);
   }
   public static int getPrice(int code) {
      switch (code) {
         case 1101:
            return 948;
         case 1102:
            return 530;
         case 1103:
            return 799;
         case 1104:
            return 890;
         case 1105:
            return 670;
         default: 
            return 0;
      }
   }
   public static String getItem(int code) {
      switch (code) {
         case 1101: 
            return "iPhone 5";
         case 1102:
            return "Nokia Lumia 800";
         case 1103:
            return "Sony Xperia S";
         case 1104:
            return "Samsung Galaxy S3";
         case 1105: 
            return "Samsung Galaxy Note";
         default: 
            return "    You have input an invalid code...";
      }
   }
   public static double calculateGST(double totalwithoutgst) {
      return totalwithoutgst*0.07;
   }
   public static double calculateTotal(double totalwithoutgst, double gst) {
      return totalwithoutgst+gst;
   }
   public static void displayTotal(int code, String description, int price, int quantity, double totalcost, double gst, double totalwithoutgst) {
      System.out.println("Details:  " + code + "\t" + description + "     " + "$" + price + " x " + quantity + " = $" + totalwithoutgst);
      System.out.print("Total amount = $" + totalwithoutgst + " + $" + gst + " (GST) = $" + totalcost);
   }
   public static void displayList() {
      System.out.println("Code   Item\t\t   Price ($)");
      System.out.println("1101   iPhone 5\t\t   948.0");
      System.out.println("1102   Nokia Lumia 800\t   530.0");
      System.out.println("1103   Sony Xperia S\t   799.0");
      System.out.println("1104   Samsung Galaxy S3   890.0");
      System.out.println("1105   Samsung Galaxy Note 670.0\n");
   }
}