
public class Coin implements Money{
	private double amount;
	public Coin(double n) {
		amount = n;
	}
	public double getAmount() {
		return amount;
	}
}
