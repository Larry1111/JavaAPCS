import java.util.Scanner;

public class HanoiTower
{
  public static void main(String[] args)
  {
    int nDisks;

    if (args.length >= 1)
    {
      nDisks = Integer.parseInt(args[0]);
    }
    else
    {
      System.out.print("Enter the number of disks: ");
      Scanner keyboard = new Scanner(System.in);
      nDisks = keyboard.nextInt();
    }
    HanoiTower program = new HanoiTower();
    program.moveTower (1, 2, nDisks);
  }

  public void moveDisk(int fromPeg, int toPeg)
  {
    System.out.println("From " + fromPeg + " to " + toPeg);
  }

  public void moveTower(int fromPeg, int toPeg, int n)
  {
    //***
	if(n>=1) {
	int sparePeg = 6 -fromPeg - toPeg;
	moveTower(fromPeg, sparePeg, n-1);
	moveDisk(fromPeg, toPeg);
	moveTower(sparePeg, toPeg, n-1);
	}
  }
}
