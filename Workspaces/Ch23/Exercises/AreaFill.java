import java.awt.Color;
import java.util.Arrays;

public class AreaFill {
	
//	public static void fillPool(Color[][] plane, int row,
//									int col, Color color) {
//			Color black =plane[row][col];
//			if(plane[row][col].equals(black))
//				plane[row][col]=color;
//			if(plane[row-1][col].equals(black))
//				fillPool(plane,row-1,col,color);
//			if(plane[row][col+1].equals(black))
//				fillPool(plane,row,col+1,color);
//			if(plane[row][col-1].equals(black))
//				fillPool(plane,row,col-1,color);
//			if(plane[row+1][col].equals(black))
//				fillPool(plane,row+1,col,color);
//	}
	public static void main(String[] args)
	{
		int[][]a = new int[2][3];
		a[0][0]=1;
		a[0][1]=2;
		a[0][2]=3;
		a[1][0]=5;
		a[1][1]=6;
		a[1][2]=7;
		System.out.println(Arrays.toString(a[1]));
	}
}
