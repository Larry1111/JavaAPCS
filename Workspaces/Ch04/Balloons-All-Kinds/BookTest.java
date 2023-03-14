import java.util.Scanner;

public class BookTest {
	public static void main(String[]args) {
		Book myBook = new Book(3);
		Scanner kboard = new Scanner(System.in);
		System.out.println("My book has  " + myBook.getNumPages() + " pages");
		System.out.println("Now the current page is page " + myBook.getCurrentPage() + ".");
		myBook.nextPage();
		System.out.println("Now the current page is page " + myBook.getCurrentPage() + ".");
		myBook.nextPage();
		System.out.println("Now the current page is page " + myBook.getCurrentPage() + ".");
		myBook.nextPage();
		System.out.println("Now the current page is page " + myBook.getCurrentPage() + ".");
		kboard.close();
	}
}
