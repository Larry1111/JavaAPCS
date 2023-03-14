
public class Diploma
  {
    private String name, subject;
    public Diploma(String nm, String subj) { name = nm; subject = subj; }
    public String toString()
    {
      return "This certifies that " + name + "\n" +
                         "has completed a course in " + subject;
    }
    public static void main(String[] args)
    {
    	Diploma diploma1= new Diploma("Adam Smith", "Gardening");
    	System.out.println(diploma1);
    	System.out.println();
    	Diploma diploma2 = new DiplomaWithHonors("Betsy Smith","Robotics");
    	System.out.println(diploma2);
    	System.out.println();
    }
  }
  