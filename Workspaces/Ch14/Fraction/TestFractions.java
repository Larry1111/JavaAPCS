import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is a test class for the Fraction class
 * Author: Blair
 */

public class TestFractions
{
  public static void testConstructors()
  {
    Fraction f1 = new Fraction();
    Fraction f2 = new Fraction(7);
    Fraction f3 = new Fraction(12, -20);
    Fraction f4 = new Fraction(f3);

    System.out.println("f1 = " + f1);
    System.out.println("f2 = " + f2);
    System.out.println("f3 = " + f3);
    System.out.println("f4 = " + f4);
    System.out.println();
  }

  public static void testArithmetic()
  {
    Fraction f1 = new Fraction(1, 2);
    Fraction f2 = new Fraction(1, 3);

    Fraction sum = f1.add(f2);
    System.out.println(f1 + " + " + f2 + " = " + sum);

    Fraction product = f1.multiply(f2);
    System.out.println(f1 + " * " + f2 + " = " + product);

    System.out.println();
  }

  public static void testValues()
  {
    Fraction f = new Fraction(2, 3);
    System.out.println(f + " = " + f.getValue());
    System.out.println();
  }
  public static void testCompare()
  {
	  Fraction f1 = new Fraction (1,2);
	  Fraction f2 = new Fraction (1,3);
	  Fraction f3 = new Fraction (1,4);
	  Fraction[] list = {f1, f2, f3};
	  Arrays.sort(list);
	  for(Fraction f: list) {
		  System.out.println(f);
	  }
  }
  public static void testEquals() {
	  ArrayList<Fraction> list = new ArrayList<Fraction>();
	  list.add(new Fraction (1,3));
	  list.add(new Fraction (1,4));
	  list.add(new Fraction (1,5));
	  System.out.println(list.contains(new Fraction(1,4)));
	  System.out.println(list.indexOf(new Fraction(1,4)));
  }
  public static void main(String[] args)
  {
    testConstructors();
    testArithmetic();
    testValues();
    testCompare();
    testEquals();
  }
}