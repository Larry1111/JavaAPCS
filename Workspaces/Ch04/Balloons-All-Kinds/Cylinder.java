
public class Cylinder {
	 private Circle base;
	 private double height;
	 //constructor
	 public Cylinder (int r, int h) {
		
		 base = new Circle(r) ;
		 height = h;
		 
	 }
	 public double getVolume() {
		 return base.getArea() * height;
	 }
	 public double getHeight() {
		 return height;
	 }
	 public Circle getBase() {
		 return base;
	 }
	 
}

