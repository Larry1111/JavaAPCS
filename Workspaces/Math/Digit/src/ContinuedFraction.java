import static java.lang.Math.pow;
import java.util.*;
import java.util.function.Function;
 import java.lang.Object;
public class ContinuedFraction{
	private static ArrayList<Double> list = new ArrayList<Double>();
	public static boolean checkPrime(int n){
		 if(n < 2) return false;
		    if(n == 2 || n == 3) return true;
		    if(n%2 == 0 || n%3 == 0) return false;
		    long sqrtN = (long)Math.sqrt(n)+1;
		    for(long i = 6L; i <= sqrtN; i += 6) {
		        if(n%(i-1) == 0 || n%(i+1) == 0) return false;
		    }
		    return true;
		}
    static double calc(Function<Double, Double[]> f, int n) {
    	for(int i= 5;i<1000000000;i+=2)
		{
		if(checkPrime(i))
		{
			list.add(1.0/i);
		}
		}
    			
        double temp = 0;
 
        for (int ni = n; ni >= 1; ni--) {
            Double[] p = f.apply((double)ni);
            temp = p[1] / (double) (p[0] + temp);
        }
        return f.apply((double) 0)[0] + temp;
    }
    
    public static void main(String[] args) {
        List<Function<Double, Double[]>> fList = new ArrayList<>();
        fList.add(n -> new Double[]{n > 0 ? list.get(n.intValue()-1) : ((double)1)/3,  1.0});
        for (Function<Double, Double[]> f : fList)
            System.out.println(calc(f, 60000001));
    }
}