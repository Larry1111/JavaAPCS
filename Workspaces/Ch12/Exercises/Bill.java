
public class Bill implements Money {
	private int n;
	public Bill(int i) {
		n = i;
	}

	public String toString() {
		return "$" + n;
	}
	public double getAmount() {
		return n;
	}

}
