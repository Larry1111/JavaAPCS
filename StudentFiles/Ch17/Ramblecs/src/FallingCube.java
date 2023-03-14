/** Represents a falling cube in the Ramblecs game
 */

public class FallingCube extends LetterCube
{
  private int cubeSize;
  private int xCoord, yCoord;

  public FallingCube(int size)
  {
    cubeSize = size;
  }

  public int getSize()
  {
    return cubeSize;
  }

  public int getX()
  {
    return xCoord;
  }

  public int getY()
  {
    return yCoord;
  }

  public void move(int x, int y)
  {
    xCoord = x;
    yCoord = y;
  }
}

