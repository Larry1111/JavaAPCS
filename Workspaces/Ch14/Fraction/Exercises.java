
//public class Exercises implements Comparable<Person>{
//	public int compareTo(Person other) {
//		if(getLasttName().compareTo(other.getLastname())==0) {
//			return getLastName().compareTo(other.getLastname());
//		}
//		else return this.getLasttName().compareTo(other.getLastname());
//	}
//8
public class Exercises{
	public static int search(int[] a, int m, int n, int target) {
		if(n-m == 0) {
			return -1;
		}
		int middle = (m+n)/2;
		if(target == a[middle]) {
			return middle;
		}
		int p = search(a, target, m, middle -1);
		return p;
	}
	//7 
	public static int findX(String s) {
		int length = s.length(); 
		   if (s.charAt(0)!='X' || length==0) 
			   return 0; 
		   if (s.charAt(length-1)=='X') 
			   return length;
		   return findX(s.substring(0,length/2)) + findX(s.substring(length/2));
		   
	}
	public static void main(String[] args) {
		String k = "XXXXXXOOOOOOOO";
		System.out.println(findX(k));
	}
}

