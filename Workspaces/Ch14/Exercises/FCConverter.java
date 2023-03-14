
public class FCConverter
	{
	  private double Celsius;
	  private double Fahrenheit;
	  public double setFahrenheit (double degrees)
	  {
	      Celsius = (degrees - 32) * (5.0 / 9);
	      return 0;
	  }
	  public double getCelsius ()
	  {
	      return Celsius;
	  }
	  public double setCelsius (double degrees)
	  {
		  Fahrenheit = (degrees * 9.0 / 5 + 32);
	      return 0;
	  }
	  public double getFahrenheit ()
	  {
	      return Fahrenheit;
	  }
}

