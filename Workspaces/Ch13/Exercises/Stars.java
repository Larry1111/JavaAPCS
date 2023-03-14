
public class Stars {
	private static int m = 0;
	public static void printStars(int n) {
		if(n==0) {
			return;
		}
		System.out.print("*");
		printStars(n-1);
	}
	public static void printTriangle(int n) {
		if(n==0) {
			return;
		}
		printStars(n);
		System.out.print("\n");
		printTriangle(n-1);
	}
	public static void printTriangle2(int n) {
		if(n==0) {
			return;
		}
		printStars(m+1);
		m+=1;
		System.out.print("\n");
		printTriangle2(n-1);
	}
	public static void main(String[] args) {
		
		printTriangle(5);
		//printTriangle2(5);
	}
}
