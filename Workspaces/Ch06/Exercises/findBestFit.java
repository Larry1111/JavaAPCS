import java.util.Scanner;

public class findBestFit {
	private static int number;
	public static int bestFit(int size1, int size2, int space) {
		int n = size1;
		int m = size2;
		int s = space;
		if (m + n <= s)
			number = 3;
		else if (m == n && m<=s)
			number = 1;
		else if (m > n && m <= s)
			number = 2;
		else if (n > m && n <= s)
			number = 1;
		else if (m > n && n <= s)
			number = 1;
		else if (n > m && m <= s)
			number = 2;
		else 
			number = 0;
		return number;
	}
	public static void main(String[] args) {
		while(true) {
		Scanner scanner =  new Scanner(System.in);
		System.out.println("Enter the size of file 1: ");
		String file1 = scanner.next();
		int File1 = Integer.parseInt(file1);
		System.out.println("Enter the size of file 2: ");
		String file2 = scanner.next();
		int File2 = Integer.parseInt(file2);
		System.out.println("Enter the space size: ");
		String space = scanner.next();
		int Space = Integer.parseInt(space);
		System.out.println(bestFit(File1,File2, Space));
		}
	}
}