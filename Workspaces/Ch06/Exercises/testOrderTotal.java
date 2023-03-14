import java.util.Scanner;

public class testOrderTotal extends getOrderTotal{
	public static void main(String[] args) {
		while(true)//always true, never false, this loop will keep running
		{
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the number of Be Prepared book: " );
			String bp = scanner.next();
			int Bp = Integer.parseInt(bp);
			System.out.println("Enter the number of Next Best book: " );
			String nb = scanner.next();
			int Nb = Integer.parseInt(nb);
			total = getOrderTotal(Bp, Nb);
			System.out.println("The total order is $" + total);

		}
}
}
