import java.util.Scanner;

public class count {
	private static int one,two,three,four,five,six,seven,eight,nine;
	private static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number: ");
		String contents = input.next();
		for(int i= 0; i < contents.length(); i++)
		{
			
			switch(contents)
			{
			case "1": 
				one++;
				break;
			case "2": 
				two++;
				break;
			case "3": 
				three++;
				break;
			case "4": 
				four++;
				break;
			case "5": 
				five++;
				break;
			case "6": 
				six++;
				break;
			case "7": 
				seven++;
				break;
			case "8": 
				eight++;
				break;
			case "9": 
				nine++;
				break;
			}
		}
		System.out.println("1: "+ one);
		System.out.println("2: "+ two);
		System.out.println("3: "+ three);
		System.out.println("4: "+ four);
		System.out.println("5: "+ five);
		System.out.println("6: "+ six);
		System.out.println("7: "+ seven);
		System.out.println("8: "+ eight);
		System.out.println("9: "+ nine);
	}
}