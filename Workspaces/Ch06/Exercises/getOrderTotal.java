
public class getOrderTotal {
	public static double total;
	public static double getOrderTotal(int bp, int nb) {
		int totalBooks = bp + nb;
		if (totalBooks >= 3 && totalBooks < 12) 
			total = totalBooks*16.95;
		else if (totalBooks >= 12)
			total = totalBooks * 16;
		else if (bp == 1 && nb == 1 )
			total = 39.95;
		else
			total = 20.95*bp + 21.95*nb;
	return total;
	}
	
}
