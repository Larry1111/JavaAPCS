import java.util.Scanner;

public class Excercise2 {
	public static double ln(int n) {
		double sum = 0;
		int k = 1;
		while(Math.abs(k)<=n) {
			sum += 1.0/k;
			k*=-1;
			if(k%2 == 0) {
				k++;
			}
			else {
				k--;
			}
		}
		return sum;
	}
	public static void main(String[] args) {
	Scanner kb = new Scanner(System.in);
	int input;
	System.out.println("Enter an integer: ");
	input= kb.nextInt();
	System.out.println(ln(input));
}
}

