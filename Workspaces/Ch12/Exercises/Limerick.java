
public class Limerick extends Poem{
	private int lines=5;
	
	public int getSyllables(int k)
	{
		if(k==0||k==1||k==4)
			return 9;
		else
			return 6;
	}
	
	public int numLines()
	{
		return lines;
	}
	public static void main(String[] args) {
		Poem Limerick1 = new Limerick();
		Limerick1.printRhythm();
	}

}