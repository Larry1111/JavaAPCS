import java.util.Scanner;

public class Exercise17 {
	public static double goldenRatio(int n) {
		double sum = 1;
		for(int k=1; k<n;k++) {
			sum = 1+ 1/sum;
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int input;
		System.out.println("Enter an integer: ");
		input= kb.nextInt();
		System.out.println(goldenRatio(input));
	}
}
