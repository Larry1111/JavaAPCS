
public class LipogramAnalyzer {
	
private String text;
	
	public LipogramAnalyzer(String text)
	{
		this.text=text;
	}
	
	public String mark(char letter)
	{
		return text.replace(letter, '#');
	}
	
	public String allWordsWith(char letter)
	{
		// get string length
        String temp = "", list = "\n";
        int psnE = text.indexOf(letter);
        text = " " + text + " ";
            while(psnE != -1) {
            	int m = text.lastIndexOf(" ", psnE );
            	int n = text.indexOf(" ", psnE);
                temp = text.substring(m, n);
                System.out.println(temp);
                if(list.indexOf("\n" + temp +"\n") == -1) {
                	list += temp + "\n";
                }
                psnE = text.indexOf(letter, n);
            }
            return list.substring(1);    
            }
        
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LipogramAnalyzer la=new LipogramAnalyzer("testing testing cool");
		System.out.println(la.allWordsWith('t'));
		
	}

}
