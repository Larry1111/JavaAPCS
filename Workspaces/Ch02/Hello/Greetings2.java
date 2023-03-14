/**
 * This program prompts the user to enter his or her
 * first name and last name and displays a greeting message.
 * Author: Maria Litvin
 */

import java.util.Scanner;

public class Greetings2
{
  public static void main(String[] args)
  {
    Scanner kboard = new Scanner(System.in);

    System.out.print("What is your favorite movie? ");
    String favmov = kboard.nextLine();

    System.out.println("I think " + favmov + "is a terrible movie!");
    System.out.println("Just kidding! I like " + favmov + ", too.");

    kboard.close();
  }
}
