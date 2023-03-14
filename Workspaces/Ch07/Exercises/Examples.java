import java.util.Scanner;

public class Examples {
	public static double exOneWhile(int n) {
		int k = 1;
		double sum = 0;
		while (k<=n) {
			sum = sum + 1.0/(k*k);
			k++;
		}
		return sum;
	public static double exOneFor(int n2) {
		int k1 = 1;
		double sum2 = 0;
		for(k1 = 1; k1<=n; k1++) {
			sum2 = sum2 + 1.0/(k1*k1);
		}
		return sum2;
	}
	}
	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		System.out.println("Please enter an integer: ");
		int input = kboard.nextInt();
		System.out.println("The sum is: "+ exOneFor(input));
		System.out.println("pi^2/6 = " + Math.PI*Math.PI/6);
	}
	
	
}
