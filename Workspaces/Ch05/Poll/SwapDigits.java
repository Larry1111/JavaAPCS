import java.util.Scanner;
public class SwapDigits{
	private int tens;
	private int units;
	private int rest;
	public int SwapDigits(int n) {
	    tens = (n/10)%10;
	    units = n%10;
	    rest = n-n%100;
	    return rest+units*10+tens;
	}
	public static void main(String[] args) {
		System.out.println("Enter an integer: ");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		SwapDigits c = new SwapDigits();
		System.out.println("The new number is: " + c.SwapDigits(n));
	}
}
