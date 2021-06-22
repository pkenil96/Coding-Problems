import java.util.*;
import java.lang.*;

class StrangeButEasy{
	public static void main (String[] args) throws java.lang.Exception	{
		Scanner sc = new Scanner(System.in);
		int t = 0;
		if(sc.hasNext())
			t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			ArrayList <Integer> ans = new ArrayList<>();
			int [] primes = new int[1000005];
			for(int i=2; i<1000005; i++)
				primes[i] = 1;
			
			for(int i=2; i<1000005; i++){
				if(primes[i] == 1){
					for(int j = i*i; i<1000005; j+=i){
						primes[j] = 0;	
					}
				}
			}
			
			for(int i=2; i<1000005; i++){
				if(primes[i] == 1){
					ans.add(i);
				}
			}
			int a = ans.get(2*n + 1);
			int b = ans.get(2*n + 2);
			int c = ans.get(3*n);
			System.out.println((a*b)+c);
			t--;
		}
	}
}
