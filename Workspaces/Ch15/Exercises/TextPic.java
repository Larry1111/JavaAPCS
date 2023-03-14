
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TextPic
{
  private int rows, cols;
  private char pixels[][];

  public TextPic(String fileName)
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
	  rows = input.nextInt();
	  cols = input.nextInt();
	  input.nextLine(); // MOVE TO THE NEXT LINE OF THE FILE
	  pixels = new char[rows][cols];
	  for(int row = 0; row<rows; row++)
	  {
		  String s = input.nextLine();
		  for (int col = 0; col < cols; col++)
		  {
			  pixels[row][col] = s.charAt(col);
		  }
	  }
	  input.close();
  }

 

  public String toString()
  {
	  String output = "";
	  for(int r = 0; r < rows; r++)
	  {
		  for(int c = 0; c < cols; c++)
		  {
			  output += pixels[r][c];
		  }
		  output += "\n";  
	  }
	  return output;
  }
  public void toFile(String fileName)
  {
	  //create the output file, which changes the original image by
	  // replacing all 'x' characters with '#' and all '.' with spaces
	 File file = new File(fileName);
	 PrintWriter output = null;
	 try
	 {
		 output = new PrintWriter(file);
	 }
	 catch(FileNotFoundException ex)
	 {
		 System.out.println("Error creating: " + fileName);
		 System.exit(1);
	 }
	 String s = "";
	 for(int row = 0; row<rows; row++)
	 {
		
		for (int col = 0; col < cols; col++)
		{
			  if(pixels[row][col] == 'x')
			  		s+='#';
			  else
			  		s+= ' ';
		 }
		output.println(s);
		s = "";
	  }
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
    TextPic img = new TextPic(fileIn);
    System.out.println(img);
    img.toFile(fileOut);
  }
}
