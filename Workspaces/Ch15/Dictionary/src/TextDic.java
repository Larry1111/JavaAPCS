
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TextDic
{
  ArrayList<String> list = new ArrayList<String>();
  public TextDic(String fileName)
  {
	// open the file and initialize pixels with its contents
	  File file = new File(fileName);
	  Scanner input = null;
	  try
	  {
		  input = new Scanner(file);
	  }
	  catch(FileNotFoundException ex)
	  {
		  System.out.println("Can't open " + fileName);
		  System.exit(1);
	  }
	  // MOVE TO THE NEXT LINE OF THE FILE  
	  while(input.hasNextLine())
	  {
		  String s = input.nextLine().toUpperCase();
		  list.add(s);
	  }
	  input.close();
  }

 

  public String toString()
  {
	  String output = "";
	  for(String s: list)
	  {
		  output+=s+"\n";
	  }
	  return output;
  }
  public void toFile(String fileName)
  {
	 File file = new File(fileName);
	 PrintWriter output = null;
	 try
	 {
		 output = new PrintWriter(file);
	 }
	 catch(FileNotFoundException ex)
	 {
		 System.out.println("Error creating: "+fileName);
		 System.exit(1);
	 }
	 output.print("public class RamblecsDictionary"+
			 		"\n" + "{" + "\n" + "	private String[] words = " +
			 		"\n" + "	{" + "\n");
	 String s = "";
	 for(int row = 0; row< list.size(); row++)
	 {
		
		if(list.get(row).length() >= 3 && list.get(row).length() <=5)
		{
			s = "		\"" + list.get(row) + "\"" + "," + "\n";
		}
		output.print(s);
		s = "";
	  }
	 output.print("	};" + "\n" + "}");
	 output.close();
	  
  }

  public static void main(String[] args)
  {
    String fileIn, fileOut;

    Scanner kboard = new Scanner(System.in);
    System.out.print("Enter image file name: ");
    fileIn = kboard.nextLine();
    System.out.print("Enter output file name: ");
    fileOut = kboard.nextLine();
    TextDic img = new TextDic(fileIn);
    System.out.println("Done");
    img.toFile(fileOut);
  }
}


