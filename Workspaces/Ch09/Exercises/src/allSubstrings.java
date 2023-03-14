import java.util.Arrays;

public class allSubstrings {
	public static String[] allSubs(String string){
		String subStr = "";
		int strlen = string.length();
		int k = 0;
		//Number of substrings for a string of n length would be (n*(n+1))/2
		int arrlen = (strlen * (strlen+1)) / 2;
		//An array to store all substrings
		String strArr[] = new String[arrlen];
		
		//Outer loop advances the initial letter for a substring
		for(int i=0 ; i<string.length() ; i++)
		{
			subStr = String.valueOf(string.charAt(i));
			strArr[k++] = subStr;
			
			//Inner loop - iterate till the ending letter of string
			for(int j=i+1 ; j<string.length() ; k++ )
			{
				subStr = subStr + String.valueOf(string.charAt(j++));
				strArr[k] = subStr;
			}
		}		
			return strArr;
	}
	public static String[][] allS(String[] words){
		int n = words.length;
		String[][] s2 = new String[n][];
		for(int i=0; i<n; i++) {
			String m = words[i];
			s2[i]= allSubs(m);
		}
		return s2;
//		for (int[] row : t)
//		  {
//		    sums[k++] = sumOfValue(row);
//		  }
//		  return sums;
//		}
	}
	
	
	public static void main(String[] args) {
		String[] arr = {"cat","to","bird"};
		Examples.output2D(allS(arr));
	}
	
}
