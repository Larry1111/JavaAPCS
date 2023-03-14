import java.util.Scanner;

public class Exercise26 {
	public static int product(int a, int b) {
		int sum = 0;
		for(int k =0; k<b;k++) {
			sum+=a;
		}
	return sum;
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int input;
		int input2;
		System.out.println("Enter an integer: ");
		input= kb.nextInt();
		System.out.println("Enter an integer: ");
		input2= kb.nextInt();
		System.out.println(product(input,input2));
	}
}
