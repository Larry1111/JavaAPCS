import java.awt.Color;

public class Homework {
			//4
			public static boolean sameScores(int[] scores)
			{
				if(scores[0] == scores[scores.length-1])
				{
					return true;
				}
				else
					return false;
			}
			//6
			//mysteryCount method counts the number of 0s before the first non-zero integer in array v.
			//9
			public static int[] makePythagoreanTriple(int m, int n)
			{
				int[]d = new int[3];
				int a = Math.abs(m*m-n*n);
				int b = 2*m*n;
				int c = m*m+n*n;
				if(a<b)
				{
					d[0]=a;
					d[1] = b;
					d[2] = c;
				}
				else if(a>=b)
				{
					d[0]=b;
					d[1] = a;
					d[2] = c;
				}
				return d;
			}
			//10
			public static int[] createWedge(int n) {
			    int[] arr = new int[2*n-1];
			    for (int i = 0; i < n; i++)
			        arr[i] = i + 1;
			    int j = n;
			    for (int g = n - 1; g > 0; g--)
			        arr[j++] = g;
			    return arr;
			}
			//11
			public static int[] Fibonacci(int n)
			{
				int[] a = new int[n];
				a[0]=0;
				a[1]=1;
				for(int i=2; i<n; i++)
				{
					a[i]=a[i-1]+a[i-2];
				}
				return a;
			}
			//15
			public static void fillCheckerboard(Color[][] board)
			{
				for(int i=0;i<board.length;i++)
				{
					
					for(int j=0;j<board[i].length;j++)
					{	
						if(i%2==0) {
						if(j%2==0)
						{
							board[i][j]=Color.white;
						}
						else
						{
							board[i][j]=Color.black;
						}
						}
						else {
							if(j%2==0)
							{
								board[i][j]=Color.black;
							}
							else
							{
								board[i][j]=Color.white;
							}
						}
					}
				}
			}
			//20
			public static int[][] pascalTriangle(int n)
			{
				int[][] triangle= new int[n][];
				
				
				for(int i=0;i<n;i++)
				{
					triangle[i]=new int[i+1];
					
					for(int j=0;j<triangle[i].length;j++)
					{
						if(j==0||j==triangle[i].length-1)
							triangle[i][j]=1;
						else
						{
							triangle[i][j]=triangle[i-1][j-1]+triangle[i-1][j];
						}
					}
				}
				return triangle;
			}

			//22
//			char[] hello = {' ', 'h', 'e', 'l','l','o'};
//			int i= 0;
//			while(i<5)
//			{
//				i++;
//				hello[i-1] = hello[i];
//			}
//			hello[5]='!';
			//23
			public static boolean isMedian(double[] sample, double m)
			{
				int countLess = 0;
				int countGreater = 0;
				for(double x: sample)
				{
					if(x > m)
					{
						countGreater++;
					}
					if(x < m)
					{
						countLess++;
					}
				if (countLess == countGreater) {
					return true;
				}
				else
					return false;
				}
			}
			public static void main(String[] arg) {
				String[][] arr = new String[4][4];
				Examples.printIntArray(Fibonacci(9));
			}
}

			
			
