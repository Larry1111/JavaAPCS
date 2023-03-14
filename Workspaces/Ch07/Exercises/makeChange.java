import java.util.Scanner;

public class makeChange {
	public static void cent(int n) {
		int quarters=0, dimes=0, nickels=0, pennies=n, c = 0;
		for(int quarter = 0; quarter <= pennies / 25; quarter++) {
			int amountAfterQuarter = pennies - (quarter * 25);
			            for(int dime = 0; dime <= amountAfterQuarter / 10; dime++) {
			                int amountAfterDime = amountAfterQuarter - (dime * 10);
			               for(int nickel = 0; nickel <= amountAfterDime / 5; nickel ++) {
			                  int amountAfterNickel = amountAfterDime - (nickel * 5);
			                  c++;
			                  System.out.println("Quarter: " + quarter + " dime: " + dime + " nickel: " + nickel + " pennies: " + amountAfterNickel);
			               }
			            }
		}
		System.out.println (c);
	}

	public static void main(String[] args) {
		int input;
		System.out.println("Number of pennies: ");
		Scanner kb = new Scanner(System.in);
		input = kb.nextInt();
		cent(input);
	}
}
