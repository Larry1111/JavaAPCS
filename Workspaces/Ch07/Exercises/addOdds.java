import java.util.Scanner;
public class addOdds {
	public static int odds(int n) {
		int sum1 = 0;
		for(int k = 1; k<=n; k+=2) {
			sum1 += k;
		}
		return sum1;
	}
		public static void main(String[] args) {
			while(true) {
			Scanner kboard = new Scanner(System.in);
			System.out.println("Please enter an integer: ");
			int input = kboard.nextInt();
			System.out.println("The sum is: "+ odds(input));
		}
		}
	public static int odds2(int n2) {
		int sum =0;
		int k=1;
		do
		{
			sum += 1.0/(k*k);
			k++;	
		}
		while(k<=n2);
		return sum;
	}
		
}
