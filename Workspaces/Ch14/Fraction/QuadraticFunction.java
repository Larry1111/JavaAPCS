
public class QuadraticFunction {
	private int a,b,c;
	public QuadraticFunction(int a1, int b1, int c1) {
		a = a1;
		b = b1;
		c = c1;
	}
	public QuadraticFunction(QuadraticFunction other)  // copy constructor
	  {
	    a = other.a;
	    b = other.b;
	    c = other.c;
	  }
	  
	public boolean equals(Object other) {
		if (other instanceof QuadraticFunction) {
			return compareTo((QuadraticFunction) other) == 0;
		}
		return false;
	}
	public double valueAt(double x) {
		return a*x*x + b*x + c;
	}
	public String toString() {
		if(b<0 && c>0 && a>0) {
			if(a==1) {
				return "x^2" + "+" + b + "x" + "+" + c;
			}
			else
				return a + "x^2" + b + "x" + "+" + c;
		}
		else if(b>0 && c>0 && a>0) {
			if(a==1) {
				return "x^2" + "+" + b + "x" + "+" + c;
			}
			else {
			return a + "x^2" + "+" + b + "x" + "+" + c;
			}
		}
		else if(b>0 && c<0 && a>0) {
			if(a==1) {
				return "x^2" + "+" + b + "x" + c;
			}
			else {
			return a + "x^2" + "+" + b + "x" + c;
			}
		}
		else if(b>0 && c>0 && a<0) {
			if(a==1) {
				return "x^2" + "+" + b + "x" + "+" + c;
			}
			else {
			return a + "x^2" + "+" + b + "x" + "+" + c;
			}
		}
		else if(b>0 && c<0 && a<0) {
			if(a==1)
				return "x^2" + "+" + b + "x" + c;
			else
				return a + "x^2" + "+" + b + "x" + c;
		}
		else {
			if(a==1) {
				return "x^2" + "+" + b + "x" + "+" + c;
			}
			else {
			return a + "x^2" + "+" + b + "x" + "+" + c;
			}
		}
			
	}
	
	public int compareTo(Object other) {
		if(other instanceof QuadraticFunction)
		if(a- ((QuadraticFunction)other).a==0) {
			if(b- ((QuadraticFunction)other).b==0) {
				if(c- ((QuadraticFunction)other).c==0) {
					return 0;
				}
				else {
					return c- ((QuadraticFunction)other).c;
				}
			}
			else {
				return b- ((QuadraticFunction)other).b;
			}
		}
		return a- ((QuadraticFunction)other).a;
	}
	
}
