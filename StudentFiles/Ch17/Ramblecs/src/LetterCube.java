/** Represents a letter cube for the Ramblecs game
 */

public class LetterCube
{
  private static final String aaabbcc = // Letters with different odds
    "AAAAAABBCCDDEEEEEEFGGHHIIIIIIJKKLLMMNNOOOOOOPPQRRRRSSSSTTTTUUUUVVWWXYYYYZ";
  private char cubeLetters[];     // Cube letters
  private int frontLetterIndex;

  public LetterCube()
  {
    cubeLetters = new char[6];
    setRandomLetters();
  }

  public void setRandomLetters()
  {
    for (int k = 0; k < 6; k++)
    {
      int i = (int)(Math.random() * aaabbcc.length());
      cubeLetters[k] = aaabbcc.charAt(i);
    }
    frontLetterIndex = 0;
  }

  public char getLetter()
  {
    return cubeLetters[frontLetterIndex];
  }

  public void rotateLeft()
  {
    frontLetterIndex--;
    if (frontLetterIndex < 0)
      frontLetterIndex = cubeLetters.length - 1;
  }

  public void rotateRight()
  {
    frontLetterIndex++;
    if (frontLetterIndex >= cubeLetters.length)
      frontLetterIndex =  0;
  }
}
