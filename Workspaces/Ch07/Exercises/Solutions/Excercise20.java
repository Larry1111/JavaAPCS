import java.util.Scanner;

public class Excercise20 {
	 public static void printTriangle(int n) { 
		 int s = n,l=1,i,j;
		 
		 for( i = 1; i <= n; i++) {
			 for(j = 1; j<=s; j++) {
				 System.out.print(" ");
			 }
			 for(j =1; j<=l;j++) {
				 System.out.print("*");
			 }
		System.out.println();
		s--;
		l+=2;	 
		 }
		
	 }
	 public static void main(String[] args) {
		 System.out.println("Enter the number of rows: ");
		 Scanner kb = new Scanner(System.in);
		 int input;
		 input = kb.nextInt();
		 printTriangle(input);
	 }
}
	    
	
//public static int LCF(int a, int b) {
//	while(a>0) {
//		b=a;
//		a =temp%a;
//	}
//	return b;
//}
//public void static main(String[]args) {
//	int a, b;
//	
//}