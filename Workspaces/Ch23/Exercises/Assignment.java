
public class Assignment {
	//1
	public static double max(double[] v, int n)
	{
		double m = v[n-1];
		if (n>1)
		{
			double m2 = max(v,n-1);
			if (m2 > m)
				m = m2;
		}
		return m;
	}
	//8
	public static String removeConsecutiveDuplicateChars(String str) 
	{	
		if(str.length() <= 1) 
			return str;
	    if(str.substring(0,1).equals(str.substring(1,2)) ) 
	    	return removeConsecutiveDuplicateChars(str.substring(1));
	    else 
	    	return str.substring(0,1) + removeConsecutiveDuplicateChars(str.substring(1));
	}
		 
	//9
	public static long countPaths(int x, int y)
	{
		if(x == 0 || y == 0)
			return 1;
		else
			return countPaths(x-1,y)+countPaths(x,y-1);
	}
	public static void main(String[] args) {
		double x[]= {3,5,4,9,2,1,0};
		String s = "ABBCCDDD";
		System.out.println(max(x, 1));
		System.out.println(countPaths(2,2));
		System.out.println(removeConsecutiveDuplicateChars(s));
	}

}
