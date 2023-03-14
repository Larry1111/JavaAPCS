import java.util.Scanner;

public class squareRoot {
	public static double sqrtEst(double a) {
		double x = a/2;
		double diff;
		do {
			x = 0.5*(x+a/x);
		}while(Math.abs(x*x-a) > 0.1);
		return x;
	}
	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		double input;
		while(true) {
		do
		{
		System.out.println("Enter a real number greater than five: ");
		input = kboard.nextDouble();
		}while(input <= 5.0);
		System.out.println("The square root of " + input + " is " + sqrtEst(input));
		}
	}

}
