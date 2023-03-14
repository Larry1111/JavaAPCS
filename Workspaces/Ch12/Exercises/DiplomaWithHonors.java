public class DiplomaWithHonors extends Diploma
	  {
	    public DiplomaWithHonors(String nm, String subj) { super(nm, subj); }
	    public String toString()
	    {
	      return super.toString() + "\n*** with honors ***";
	    }
}
