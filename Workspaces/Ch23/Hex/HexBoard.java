import java.awt.Color;

/**
 * Area fill functions for the game of Hex
 */

public class HexBoard extends CharMatrix
{
  public HexBoard(int rows, int cols)
  {
    super(rows, cols);
    
  }
  public boolean isBlack(int r, int c)
  {
	return charAt(r,c)=='B';
  }

  public boolean isWhite(int r, int c)
  {
    return charAt(r,c)=='W';
  }

  public  boolean isGray(int r, int c)
  {
    return charAt(r,c)=='g';
  }

  public void setBlack(int r, int c)
  {
    setCharAt(r,c,'B');
  }

  public void setWhite(int r, int c)
  {
    setCharAt(r,c,'W');
  }

  public void setGray(int r, int c)
  {
    setCharAt(r,c,'g');
  }

  /**
   * Returns true if there is a contiguous chain of black stones
   * that starts in col 0 and ends in the last column of the board;
   * otherwise returns false.
   */
  public boolean blackHasWon()
  {
	  int count =0;
    for(int i = 0; i<numRows();i++) 
    {
    	areaFill(i,0);
    }
    	for(int r = 0; r < numRows();r++)
    	{
    		if(isGray(r,numCols()-1))
    			count++;
    		for(int c=0;c<numCols();c++)
    		{
    			if(isGray(r,c))
    				setBlack(r,c);
    		}
    	}
    return count>0;
    
    
  }

  /**
   * Fills the contiguous area that contains r,c with gray color.
   * Does nothing if r, c is out of bounds or is not black.
   */
  public void areaFill(int r, int c)
  {
	  if(!isInBounds(r,c)||!isBlack(r,c))
	  {
		  return;
	  }
	  setGray(r,c);
	  areaFill(r-1,c);
	  areaFill(r+1,c);
	  areaFill(r,c-1);
	  areaFill(r,c+1);
	  areaFill(r-1,c-1);
	  areaFill(r+1,c+1);
  }

  public String toString()
  {
    String s = "";

    for (int r = 0; r < numRows(); r++)
    {
      for (int c = 0; c < numCols(); c++)
      {
        if (isBlack(r, c))
          s += 'B';
        else if (isWhite(r, c))
          s += 'W';
        else if (isGray(r, c))
          s += 'X';
        else
          s += '.';
      }
      s += '\n';
    }
    return s;
  }

  //****************************************************************

  private boolean isInBounds(int row, int col)
  {
    return row>=0&&col>=0&&row<numRows()&&col<numCols();
  }
}