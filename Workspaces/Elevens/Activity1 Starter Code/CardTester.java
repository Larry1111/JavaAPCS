/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		Card card1 = new Card("Ace "," hearts", 11);
		Card card2 = new Card("Ace ", " hearts", 1);
		Card card3 = new Card("Ace ", " diamonds", 11);
		Card card4 = new Card("King ", " hearts", 11);
		System.out.println(card1.toString());
		System.out.println(card2.toString());
		System.out.println(card3.toString());
		System.out.println(card4.toString());
		System.out.println(card1.rank());
		System.out.println(card1.suit());
		System.out.println(card1.pointValue());
		System.out.println(card1.matches(card1));
		System.out.println(card1.matches(card2));
		System.out.println(card1.matches(card3));
		System.out.println(card1.matches(card4));


	}
}
