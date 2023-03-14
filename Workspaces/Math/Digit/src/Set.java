import java.io.*;
class Set{
	public static int nextPrime(int start){
	    int next = start+1;

	    while(!isPrime(next)){
	        next++;
	    }

	    return next;
	}
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("M = ");
        int m = Integer.parseInt(br.readLine());
        System.out.print("N = ");
        int n = Integer.parseInt(br.readLine());
        for(int i = m; i <= n; i++){
            int p1 = i;
            int p2 = nextPrime(p1);
            int p3 = nextPrime(nextPrime(p1));
            if(p2 > n || p3 > n)
                break;
            if(isPrime(p1) && p2-p1==6 && p3-p1==12)
                System.out.println(p1 + ", " + p2 + ", " + p3);
            p1 = i;
            p2 = nextPrime(p1);
            p3 = nextPrime(nextPrime(p1));
            if(p2 > n || p3 > n)
                break;
            if(isPrime(p1) && p2-p1==6 && p3-p1==12)
                System.out.println(p1 + ", " + p2 + ", " + p3);
        }
    }
    public static boolean isPrime(int n){
        int f = 0;
        for(int i = 1; i <= n; i++)
            if(n % i == 0)
                f++;
        return f == 2;
    }
}