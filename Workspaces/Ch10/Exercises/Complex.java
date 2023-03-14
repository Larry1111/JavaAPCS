import java.util.Scanner;

public class Complex {
	private double real;
	private double imag;
	public Complex(double real)
	{
		this.real = real;
		this.imag = 0.0;
	}
	public Complex(double real, double imaginary)
	{
		this.real=real;
		this.imag =imaginary;
	}
	public String toString() {
        if (imag == 0) return real + "";
        if (real == 0) return imag + "i";
        if (imag <  0) return real + " - " + (-imag) + "i";
        return real + " + " + imag + "i";
    }
	public double abs()
	{
		 
		return Math.sqrt(real*real+imag*imag);
	}
	public Complex add(Complex other) {
	
		double newReal = other.real+ real;
		double newImag = other.imag +imag;
		return new Complex(newReal, newImag);
	}
	public Complex times(Complex b) {
       
        double newReal = real * b.real - imag * b.imag;
        double newImag = real * b.imag + imag * b.real;
        return new Complex(newReal, newImag);
    }
	public Complex add(double a, double b)
	{
		
		 double newReal = real+a;
		 double newImag = imag+b;
		 return new Complex(newReal, newImag);
	}
	public Complex times(double a, double b)
	{
		double newReal = real*a-imag*b;
		double newImag = real*b-imag*a;
		return new Complex(newReal, newImag);
	}
	public static void main(String[] args) {
		System.out.println("Enter the real part for complex number z1: ");
		Scanner kb= new Scanner(System.in);
		double real1= kb.nextDouble();
		System.out.println("Enter the imaginary part for complex number z1: ");
		double imag1= kb.nextDouble();
		System.out.println("Enter the real part for complex number z2: ");
		double real2= kb.nextDouble();
		System.out.println("Enter the imaginary part for complex number z2: ");
		double imag2= kb.nextDouble();
		Complex z1 = new Complex(real1,imag1);
		Complex z2 = new Complex(real2,imag2);
		System.out.println("z1 + z2 = "+ z1.add(z2));
		System.out.println("z1 * z2 = " + z1.times(z2));
		System.out.println("The absoluate value of z1 is "+ z1.abs());
		System.out.println("The absoluate value of z2 is "+ z2.abs());
	}
}
