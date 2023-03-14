import java.util.Scanner;

public class Chap8 {
	//2b
	public static boolean twoStar(String str)
	{
		if(str.length()>=2 && str.charAt(str.length()-1)=='*' && str.charAt(str.length()-2)=='*')
			return true;
		else 
			return false;
	}
	
	//3
	public static String removeDashes(String str)
	{
		String num = str.replace("-", "");
		return num;
	}
	
	//5b
	public static String last5(String str)
	{	
		String ccNumber = "4111 1111 1111 1111";
		String newNum = ccNumber.replace(" ", "");
		String last5 = newNum.substring(newNum.length()-5);
		return last5;
	}
	
	//7
	public static String convertName(String str)
	{
		String str2 = str.trim();
		int indexComma = str2.indexOf(",");
		String name = str2.substring(indexComma+1, str2.length()) + " " + str2.substring(0, indexComma); 
		return name;
	}
	
	//8
	public static String posToNeg(String str)
	{
		String str2 = str.replace("1", "2").replace("0", "1");
		String str3 = str2.replace("2", "0");
		return str3;
	}
	
	//13
	public boolean StartsWith(String prefix)
	{
	
		int n = this.indexOf(prefix);
		int n1 = n+prefix.length();
		if(this.substring(n, n1).equals(prefix))
			return true;
		else
			return false;
	}
	public boolean EndsWith(String suffix)
	{
		int n = this.indexOf(suffix);
		int n1 = n+suffix.length();
		if(this.substring(n, n1).equals(suffix))
			return true;
		else
			return false;
	}
	
	//16
	// No, since compareTo() compares the first digits of n1 and n2.
	// For example when n1 = 9 and n2 = 10, s1.compareTo(s2) is positive 1, but 
	// n1 - n2 = -1. In this case, s1.compareTo(s2) has opposite sign with (n1-n2).
	//20
	public static boolean isValidISBN(String isbn)
	{
		int sum = 0, n;
		if(isbn.length()!=13)
		{
			return false;
		}
		for (int i=0; i<13; i++) {
			char s1 = isbn.charAt(i);
			n = Character.digit(s1, 10);
			if(i%2==0) {
				sum+=n;
			}
			else
			{
				sum+=3*n;
			}
		}
		return (sum%10 == 0);
	}
	
	public static void main(String[] args) {
		while(true) {
		Scanner kboard = new Scanner(System.in);
		String input = kboard.nextLine();
		System.out.println(isValidISBN(input));
		}
	}
}
