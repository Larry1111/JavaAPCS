import java.util.ArrayList;


public class LineList {
	private ArrayList<String> arr;
	public LineList()
	{
		arr = new ArrayList<String>();
	}
	public int size() 
	{
		return arr.size();
	}
	public String get(int k)
	{
		return arr.get(k);
	}
	public void add(String line)
	{
		arr.add(line);
	}
	public String remove(int k)
	{
		String temp = arr.get(k);
		arr.remove(k);
		return temp;
	}
	public void move(int index, int newIndex)
	{
		String temp = arr.get(index);
		arr.remove(index);
		arr.add(newIndex,temp);
	}
	public void shuffle()
	{
		int n =arr.size();
		while(n>=1) {
			int j = getRandom(n-1);
			String temp = arr.get(j);
			arr.set(j,arr.get(n-1));
			arr.set(n-1,temp);
			n--;
		}
	}
	private int getRandom(int n) {
		return (int)((Math.random())*n);
	}
}
