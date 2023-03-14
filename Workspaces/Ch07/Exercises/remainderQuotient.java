import java.util.Scanner;

public class remainderQuotient {
	public static void divWOdiv(int m, int n) {
		int quotient = 0;
		int remainder = m;
		while(remainder >= n) {
			remainder -= n;
			quotient++;
		}
	}
	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		int m, n;
		while(true)
			System.out.println("Enter m: ");
			m = kboard.nextInt();
			System.out.println("Enter n: ");
			n = kboard.nextInt();
		System.out.println(quotient);
	}

}
