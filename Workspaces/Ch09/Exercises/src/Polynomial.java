
public class Polynomial {
	 private double[] coef;  // coefficients
	 private int deg;     // degree of polynomial (0 for the zero polynomial)
	    // a * x^b
	    public Polynomial( double[] a ){
	        coef = new double[ a.length+1 ];// make sure to copy a instead of just setting coeffcient to a so that when a is changed coefficient does not change
	        for( int i = 0; i < a.length; i++ ){
	            coef[ i ] = a[ i ];
	        deg = degree();
	    }
	    }
	    
	    // return the degree of this polynomial (0 for the zero polynomial)
	    public int degree(){
	        int d = 0;
	        for( int i = 0; i < coef.length; i++ )
	            if( coef[ i ] != 0 ) 
	            	d = i;
	        return d;
	    }    
	    /*
	     Implement the division as described in wikipedia
	        function n / d:
	          require d ≠ 0
	          q ← 0
	          r ← n       # At each step n = d × q + r
	          while r ≠ 0 AND degree(r) ≥ degree(d):
	          t ← lead(r)/lead(d)     # Divide the leading terms
	          q ← q + t
	          r ← r − t * d
	          return (q, r)
	     */
	    // use Horner's method to compute and return the polynomial evaluated at x
	    public double evaluate(double d){
	        double p = 0;
	        for( int i = deg; i >= 0; i-- )
	            p = coef[ i ] + ( d * p );
	        return p;
	    }
	    // convert to string representation
	    public String toString(){
	        if( deg == 0 ) 
	        	return "" + coef[ 0 ];
	        if( deg == 1 ) 
	        	return coef[ 1 ] + "x + " + coef[ 0 ];
	        String s = coef[ deg ] + "x^" + deg;
	        for( int i = deg - 1; i >= 0; i-- ){
	            if( coef[ i ] > 0 ){
	                s = s + " + " + ( coef[ i ] );
	            }else if( coef[ i ] < 0 ) 
	            	s = s + " - " + ( -coef[ i ] );
	            if( i == 1 ){
	                s = s + "x";
	            }else if( i > 1 ) 
	            	s = s + "x^" + i;
	        }
	        return s;
	    }	    
	    public static void main(String[] args)  
	    {    
	    	double [] d = {2,-3,4,0.5};
	        Polynomial p = new Polynomial(d);
	        System.out.println ( "The degree of " + p + " is " + p.degree());
	        System.out.println ("p(-2.5) =" + p.evaluate(-2.5));      
	   }
	    }
