import java.util.Comparator;

public class ComplexComparator implements Comparator<Complex>{
	private char x;
	public ComplexComparator(char c) {
		x =c;
	}

	@Override
	public int compare(Complex o1, Complex o2) {
		// TODO Auto-generated method stub
		if(x == 'a') {
			if(o1.geta()>o2.geta()) {
				return 1;
			}
			else if(o1.geta()<o2.geta()) {
				return -1;
			}
			return 0;
		}
		if(x == 'b') {
			if(o1.getb()>o2.getb()) {
				return 1;
			}
			if(o1.getb()<o2.getb()) {
				return -1;
			}
			return 0;
		}

	}
}
