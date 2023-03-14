import java.util.Scanner;
//Excercise 7
public class javaDeveloper {
	public static int progress() {
		int months = 0;
		double percentUnknown = 100;
		double percentKnown = 0;
		while(percentKnown < 95) {
			percentUnknown *= 0.9;
			percentKnown = 100- percentUnknown;
			months++;
		}
		return months;
	}
	public static void main(String[] args) {
	int p = progress();
		System.out.println("After " + p/12 + " years and " + p%12 + " months, Kevin will become a certified java developer.");
	}

}
