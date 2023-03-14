import java.util.Scanner;

public class CurrentTimes {
	private int totalMins;
	public static int RemainingTime(int CurrentHour, int CurrentMin, int depHour, int depMin)
	  {
		
		int totalMin = (depHour - CurrentHour)*60 + depMin - CurrentMin;
	    return totalMin;
	    System.out.println(totalMins/60 + "hours and" + totalMins%60 + "minutes.");
	    
	  }
	public static void main(String[] args)
	  {
	    Scanner kboard = new Scanner(System.in);

	    System.out.print("Feet: ");
	    int feet = kboard.nextInt();

	    System.out.print("Inches: ");
	    int inches = kboard.nextInt();

	    kboard.close();

	    int totalMin = toInches(feet, inches) ;

	    System.out.println(totalMins/60 + " feet and " + inches + " inches = " + totalInches + " inches");
	  }

}
