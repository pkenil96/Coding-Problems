import java.util.*;
import java.lang.*;

class Prime1{
	public static void main (String[] args) throws java.lang.Exception{
		Scanner sc = new Scanner(System.in);
		int	t = sc.nextInt();
		while(t > 0){
		    t--;
			int a = sc.nextInt();
			int b = sc.nextInt();
			int [] primes = new int[Integer.MAX_VALUE];
			primes[1] = 0;
	        for(int i=2; i<primes.length; i++)
	            primes[i] = 1;
	            
	        for(int i=2; i<primes.length; i++){
	            if(primes[i] == 1){
	                for(int j=i*i; j<primes.length; j+=i)
	                    primes[j] = 0;
	            }
	        }
	        
	        for(int i=a; i<=b; i++){
	            if(primes[i] == 1)
	                System.out.println(i);
	        }
		}
	}
}
