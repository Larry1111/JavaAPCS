import java.util.Scanner;
//Exercise 5
public class HelloNTimes {
	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		System.out.print("Enter a positive integer: ");
		int n = kboard.nextInt();
		kboard.nextLine();
		System.out.print("Enter a line of text: ");
		String text = kboard.nextLine();
		kboard.close();
		for(int k = 0; k<n; k++) {
			System.out.println(text);
		}
	}
}