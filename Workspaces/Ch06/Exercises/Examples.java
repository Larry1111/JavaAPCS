import java.util.Scanner;
public class Examples {
	public static int max(int x, int y)
	{
		if (x>y)
			return x;
		else
			return y;
	}
	public static int max (int x, int y, int z)
	{
		if(x>=y && x >= z)
			return x;
		else if(y>=x && y >=z)
			return y;
			else 
				return z;
			
	}
	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		while(true)//always true, never false, this loop will keep running
		{
			System.out.print("Enter three numbers: ");
			int a = kboard.nextInt();
			int b = kboard.nextInt();
			int c = kboard.nextInt();
			System.out.println("The max is " + max(a,b,c));
		}
	}
}
