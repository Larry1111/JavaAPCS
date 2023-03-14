import java.util.Scanner;

public class printCheckerBoard {
	public static void printCheckerboard(int n) {
		int height = n;
		int length = n;
	    for (int i = 1; i <= height; i++) {
	        char first = 'o';
	        char second= '#';
	        if (i % 2 == 0) {
	            first = '#';
	            second = 'o';
	        }
	        for (int j = 0; j < length; j++) {
	            if (j % 2 == 0) {
	                System.out.print(first);
	            } else {
	                System.out.print(second);
	            }
	        }
	        System.out.println("");
	    }
	    }
	public static void main(String[] args) {	
		Scanner kboard = new Scanner(System.in);
		System.out.println("Enter an integer: ");
		int input;
		input = kboard.nextInt();
		
		printCheckerboard(input);
	}
	}
	