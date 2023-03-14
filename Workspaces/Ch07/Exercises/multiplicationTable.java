public class multiplicationTable {
	   public static void main(String[] args) {
	      int mult;
	      // print main table
	      for (int i = 1; i <= 12; i++) {
	         System.out.print(i);
	         if (i < 10) System.out.print(" :");
	         else System.out.print(":");
	         for (int j = 1; j <= 12; j++) {
	            mult = i*j;
	            System.out.printf("%4d ", mult);
	            
	         }
	         System.out.println();
	      }
	   } // end of main
}
