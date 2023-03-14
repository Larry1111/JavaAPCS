import java.util.Scanner;

public class Series {
	public static String sumUnder10(int n) {
		int sum = 0 ;
		String line = "";
		for (int i =1; i<= n; i++){
			sum+=i;
			line = line + i;
			if(i!=n)
				line = line + " + ";
			else line += " = " + sum ;
		}
		return line;
	}
	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		while(true) {
		int input;
		{
		System.out.println("Please enter an integer between 1 and 9, inclusive: ");
		
		input = kboard.nextInt();
		}
		while(input > 9 || input < 1); 
		System.out.println(sumUnder10(input));
	}
	}

}
