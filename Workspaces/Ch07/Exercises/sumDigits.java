import java.util.Scanner;

public class sumDigits {
	public static int sumDigits(int n) {
		int sum =0;
		while(n>0) {
			sum += n%10;
			n = n/10;
		}
		return sum;
	}
	public static void main(String[] args) {
		while(true) {
		Scanner kboard = new Scanner(System.in);
		System.out.println("Enter an integer: ");
		int input = kboard.nextInt();
		System.out.println("The sum of the digits of "+ input + " is "+ sumDigits(input));
	}
	}
}
