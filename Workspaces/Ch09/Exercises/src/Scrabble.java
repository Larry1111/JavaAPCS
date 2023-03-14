import java.util.Scanner;

public class Scrabble {
		public static int computeScore(String word) {
			String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		    int[] values = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,3,3,10,1,1,1,1,4,4,8,4,10};
		    int sum = 0;
		    for(int i = 0; i <word.length();i++) {
		    	sum += values[alphabet.indexOf(word.charAt(i))];
		    }
		return sum;
		}
		public static void main(String[] args) {
			System.out.println(" Enter a word: ");
			Scanner kboard = new Scanner(System.in); 
			String input = kboard.nextLine();
			String input2 = input.toUpperCase();
			System.out.print(computeScore(input2));
		}
	}