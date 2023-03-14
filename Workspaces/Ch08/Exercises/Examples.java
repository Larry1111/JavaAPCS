
public class Examples {
	public static boolean endsWithStar(String str) {
		int len = str.length();
		return len>0&&str.charAt(len-1) =='*';
	}
	public static String dateS(String dateStr) {
		int a = dateStr.indexOf("/");
		int b = dateStr.indexOf("/", a+1);
		dateStr = dateStr.substring(a+1,b) + '-'+
				dateStr.substring(0,dateStr.indexOf("/"))+'-'+
				dateStr.substring(b+1);
		return dateStr;
	}
	public static String removeTag(String str) {
		int indexTag1 = str.indexOf("<");
		int indexTag2 = str.indexOf(">", indexTag1+1);
		int indexTag3 = str.indexOf("</",indexTag2+1);
		int indexTag4 = str.indexOf(">", indexTag3 +1);
		if(indexTag1 == -1 || indexTag2==-1 || indexTag3==-1 || indexTag4==-1)
		{
			return str;
		}
		else if(str.substring(indexTag1+1,indexTag2).equals(str.substring(indexTag3+2,indexTag4)))
		{
			return str.substring(indexTag2+1, indexTag3);
		}
		else
		{
			return str;
		}
	}
	public static boolean isPalindrome(String s) {
		
		String s2 = "";
		for (int j = 0; j< s.length(); j++) {
			if(Character.isLetter(s.charAt(j))){
				s2 += s.charAt(j);
			}
		}
		String s3 = s2.toString().toUpperCase();
		int n = s3.length();
	    for(int i = 0; i < n/2; i++ ) {
	        if (s3.charAt(i) != s3.charAt(n-i-1)) { 
	        	return false;
	        }
	    }
	    return true;
	}
	public static String cutOut(String s, String s2)
	{
	  int n = s.indexOf(s2);
	  if (n >= 0)
	    s = s.substring(0, n) + s.substring(n + s2.length());
	return s; 
	}
	public static boolean onlyDigits(String s)
	{
	  for (int i = 0; i < s.length(); i++)
	    if (!Character.isDigit(s.charAt(i)))
	      return false;
	  return true;
	}
	
	public static boolean CooneyLikes(String s) {
		String caps = s.toUpperCase();
		for (int i = 0; i<(caps.length()-1); i++)//Avoid out of bound
			if(caps.charAt(i) == caps.charAt(i+1))
			return true;
		return false;
	}
}
