import java.util.Scanner;

public class CylinderTest {
	public static void main(String[]args) {
		Scanner kboard = new Scanner(System.in);
		System.out.print("Enter two integers:");
		int in = kboard.nextInt();
		int in2 = kboard.nextInt();
		Cylinder d = new Cylinder(in, in2);
		System.out.println("The volume is " + d.getVolume());
		System.out.println("The area of the base is " + d.getBase());
		System.out.println("The height is " + d.getHeight());
		kboard.close();
	}
}
