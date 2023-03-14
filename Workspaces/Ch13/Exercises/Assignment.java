
public class Assignment {
	
//1
	public static int product(int a, int b) {
		if(b == 1) {
			return a;
		}
		else if(b==0) {
			return 0;
		}
		else {
			return a + product(a, b-1);
		}
	}
	
//3 EVAH NUF
//5 a,b,c,e,g,h
//7 00100123
//10
	public static int gcf(int x, int y)
	  {
	    if(x == 0) {
	    	return y;
	    }
	    else {
	    	return gcf(y % x, x);
	    }
	  }
	
//11 8
//14
	public static long fibonacci(int n) {
		int sum = 1, n0 = 0, n1 = 1;
		for(int i = 1; i < n; i++) {
			sum = n0 + n1;
			n0 = n1;
			n1 = sum;
		}
		return sum;
	}
	
//15
	public static int binomialCoeff(int n, int k) {
		int sum = 0;
		if(k==0 || n==k) {
			return 1;
		}
		else {
			sum += binomialCoeff(n-1, k-1) + binomialCoeff(n-1, k);
		}
		return sum;
	}
//17
	//For the folder class
	public boolean contains(String name) {
		for(FileItem item: items) {
			if(item.getName().equals(name)||item.contains(name))
			return true;
		}
		return false;
	}
	//For the file class
	public boolean contains(String name) {
		return false;
	}
//18
	public static double continuedFrac(int n) {
		if(n==1) {
			return 1;
		}
		else {
			return 1 + 1/continuedFrac(n-1);
		}
	}
	public static void main(String[] args) {
		System.out.println(product(4,9));
		System.out.println(continuedFrac(14));
		System.out.println(fibonacci(3));
		System.out.println(binomialCoeff(4,1));
		System.out.println(gcf(12,3));
	}
}
