import java.util.Comparator;

public class QuadraticFunctionComparator implements Comparator<QuadraticFunction> {
	private double x = 0; 
	public QuadraticFunctionComparator() {
	
	}
	public QuadraticFunctionComparator(double x)
	{
		this.x =x;
	}
	@Override
	public int compare(QuadraticFunction other1, QuadraticFunction other2) {
		return Double.compare(other1.valueAt(x), other2.valueAt(x));
	}
}
