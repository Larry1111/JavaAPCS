import java.util.Scanner;

public class CircleTest {
	public static void main(String[]args) {
		Scanner kboard = new Scanner(System.in);
		System.out.print("Enter an integer:");
		int in = kboard.nextInt();
		Circle c = new Circle(in);
		System.out.println("The area is " + c.getArea());
		System.out.println("The radius is " + c.getRadius());
		kboard.close();
	}
	
}
