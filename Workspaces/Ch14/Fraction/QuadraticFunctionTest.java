public class QuadraticFunctionTest {

	private static String comp(int c)
	{
		if (c < 0)
			return " is less than ";
		if (c > 0)
			return " is greater than ";
		return " is equal to ";
		
	}
	
	public static void main(String[] args) {
		QuadraticFunction[] fun = new QuadraticFunction[5];
		fun[0] = new QuadraticFunction(1,2,3);
		fun[1] = new QuadraticFunction(1,2,3);
		fun[2] = new QuadraticFunction(3,-2,5);
		fun[3] = new QuadraticFunction(-2,4,3);
		fun[4] = new QuadraticFunction(4,5,-2);
		
		// test toString()
		for(int i=1; i<fun.length; i++)
			System.out.println(fun[i]);
		
		System.out.println();
		
		// test valueAt()
		double x = 4;
		
		System.out.println(fun[2]+" evaluated at "+ x + "="+fun[2].valueAt(x));
		
		System.out.println();
		
		// test equals()
		
		System.out.println("checking equals:");
		
		System.out.println (fun[0] + " equals " + fun[1] + " " + fun[0].equals(fun[1]));
		System.out.println (fun[0] + " equals " + fun[2] + " " + fun[0].equals(fun[2]));
		System.out.println ();
		
		// test compareTo()
		System.out.println("checking compareTo:");
		for(int i=1; i<=3;i++)
		{	
			System.out.println(fun[0] + comp(fun[0].compareTo(fun[i])) + fun[i]);
		}
		
		// test compare(a,b) at x=0
		System.out.println("\n checking compare:");
		System.out.println (" Evaluated at x = 0: ");
		QuadraticFunctionComparator test = new QuadraticFunctionComparator();
		
		for(int i=2; i<=4;i++)
		{	
			System.out.println(fun[0] + comp(test.compare(fun[0],fun[i])) + fun[i]);
		}
		
		// test compare(a,b) at x=3
		x=3;
		System.out.println ("\n Evaluated at x = " + x + ":");
		test = new QuadraticFunctionComparator(x);
		
		for(int i=2; i<=4;i++)
		{	
			System.out.println(fun[0]+ "="+fun[0].valueAt(x) + comp(test.compare(fun[0],fun[i])) + fun[i] + "="+fun[i].valueAt(x));
		}
		
		
		

	}

}