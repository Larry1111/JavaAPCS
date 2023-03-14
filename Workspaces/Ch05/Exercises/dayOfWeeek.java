import java.time.DayOfWeek;
import java.util.Scanner; 
public class dayOfWeeek {
	
	public static int dayOfWeek(int day, int date) {
		
		return (day + date - 1) %7;
	}
public static void main(String[] args) {
			String dayString = null;
			Scanner s = new Scanner(System.in);
			System.out.println("Enter the day of the week on which the month begins: ");
			int day1 = s.nextInt();
			System.out.println("Enter the date in the month that is being found: ");
			int dayOfWeek1 = s.nextInt();
			int dayOfWeek = dayOfWeek(day1, dayOfWeek1);
			switch(dayOfWeek) {
			case 0:
				dayString = "Sunday";
				break;
			case 1:
				dayString = "Monday";
				break;
			case 2: 
	            dayString = "Tuesday"; 
	            break; 
	        case 3: 
	            dayString = "Wednesday"; 
	            break; 
	        case 4: 
	            dayString = "Thursday"; 
	            break; 
	        case 5: 
	            dayString = "Friday"; 
	            break; 
	        case 6: 
	            dayString = "Saturday"; 
	            break; 
			}
			
			System.out.println("The day of the week month " + day1 + " is "+ dayString);	
}

}
