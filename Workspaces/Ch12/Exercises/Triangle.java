// Chapter 12 Question 6

public abstract class Triangle 
{
  private double side;

  public Triangle(double side)
  {
    this.side = side;
  }

  public abstract double getPerimeter();
// {
//    if ("equilateral".equals(type))
//      return 3 * side;
//    else if ("right".equals(type))
//      return (2 + Math.sqrt(2.0)) * side;
//    else
//      throw new IllegalArgumentException("Invalid triangle type");
//}

  public abstract double getArea();
//  {
//    if ("equilateral".equals(type))
//      return Math.sqrt(3) / 4 * side * side;
//    else if ("right".equals(type))
//      return side * side / 2;
//    else
//      throw new IllegalArgumentException("Invalid triangle type");
//  }

  public double getRatio()
  {
    return getArea()/getPerimeter();
  }
  public double getSide() {
	  return side;
  }
  
  
 
  
}