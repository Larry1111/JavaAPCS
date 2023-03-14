/** Represents a 2-D array of characters for Ramblecs
 */

public class RamblecsCharMatrix
{
  public final char SPACE = ' ';
  private char[][] grid;

  // Constructor: creates a grid with dimensions rows, cols,
  // and fills it with spaces
  public RamblecsCharMatrix(int rows, int cols)
  {
    grid = new char[rows][cols];
    clear();
  }

  // Returns the number of rows in grid
  public int numRows()
  {
    return grid.length;
  }

  // Returns the number of columns in grid
  public int numCols()
  {
    return grid[0].length;
  }

  // Returns the character at row, col location
  public char charAt(int row, int col)
  {
    return grid[row][col];
  }

  // Sets the character at row, col location to ch
  public void setCharAt(int row, int col, char ch)
  {
    grid[row][col] = ch;
  }

  // Returns true if the character at row, col is a space,
  // false otherwise
  public boolean isEmpty(int row, int col)
  {
    return charAt(row, col) == SPACE;
  }

  // Fills the grid with SPACE characters.
  public void clear()
  {
    for (int r = 0; r < numRows(); r++)
    {
      for (int c = 0; c < numCols(); c++)
      {
        setCharAt(r, c, SPACE);
      }
    }
  }

  // Returns the string formed by the characters in the last row.
  public String lastRowToString()
  {
    return new String(grid[numRows() - 1]);
  }

  // Shifts all rows down by one and fills the top row with spaces.
  public void shiftDown()
  {
    int rows = numRows(), cols = numCols();

    for (int r = rows - 1; r >= 1; r--)
      for (int c = 0; c < cols; c++)
        grid[r][c] = grid[r-1][c];

    for (int c = 0; c < cols; c++)
      grid[0][c] = SPACE;
  }
}
