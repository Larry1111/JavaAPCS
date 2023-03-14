import java.util.Scanner;

public class checkPrime {
	public static boolean isPrime(int n)
	{
		boolean noFactors = true;
		if(n<=1)
			return false;
//		or if (n <= 2)
//			return n == 2;
//		if (n%2 ==0)
//			return false;
		for (int m = 2; noFactors; m++)
		{
			System.out.println("Checking "+ m);
			if (m*m > n) 
				break;
			if(m % 2 == 0) {
			if (m != 2) 
				m++;
			}
			//efficient not checking even numbers other than 2
			if (n % m == 0) 
				noFactors = false;
			else 
				noFactors = true;
		}
		return noFactors;
	}
	
	
	public static void main(String[] args) {
		Scanner kboard = new Scanner (System.in);
		int input;
		while(true) {
		do
		{
			System.out.print("Enter an integer between 1 and 9, inclusive: ");
			input = kboard.nextInt();
		} while (input > 9 || input < 1);
		System.out.println(input + " isPrime? " + isPrime(input));
		}
	}

}
