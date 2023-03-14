import java.util.Scanner;

public class isLeapYear {
	private static boolean inYear;
	private static int n;
	public static boolean IsLeapYear(int year)
    {
		n = year;
		if ((year % 4) == 0)
       {
          if ((year % 100) == 0)
          {
             if ((year % 400) == 0)
                inYear = true;
             else
            	inYear = false;
          }
          else
        	  inYear = true;
       }
		else 
			inYear = false;
       return inYear;
    }
		
	public static void main(String[] args) {
		while(true)//always true, never false, this loop will keep running
		{
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the year: ");
			String Year = scanner.next();
			n = Integer.parseInt(Year);
			if (IsLeapYear(n))
			{
				System.out.println(Year + " is a leap year.");
			}
			else
			{
				System.out.println(Year + " is not a leap year.");
			}

		}
	}
}
