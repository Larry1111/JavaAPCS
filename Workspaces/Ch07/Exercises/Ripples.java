import java.util.Scanner;

public class Ripples {
	public static void main(String[] args) {
		
		String cont ="";
		Scanner s = new Scanner(System.in); 
		do {
		
		System.out.println("Enter Quantity: "); 
		int quantity = s.nextInt(); 
		s.nextLine();
		if ((quantity%25) == 0) { 
		System.out.println("You have ordered " + quantity+ " Ripples -- $" + 0.26* quantity);
		} 
		else {
		System.out.println("Ripples can only be ordered in packs of 25");
		}
		do {
		System.out.println("Next customer (y/n): ");
		cont = s.nextLine(); 
		if (cont.equals("n")){ 
			System.out.println("Thank you for using ripple systems");
		}
		}while(!cont.equals("n")&&!cont.equals("y"));
		}while(cont.equals("y"));
		
		
		
}
	}