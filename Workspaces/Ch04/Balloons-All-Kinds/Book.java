
 public class Book {
	private int numPages;
	private int currentPage;
	public Book(int x){
		numPages = x;
		currentPage = 1;
	}
	 public int getNumPages() {
		 return numPages;
	 }
	 public int getCurrentPage() {
		 return currentPage;
	 }
	 public void nextPage() {
	 if (currentPage < numPages)
		currentPage++;
	 }
}
