/*
	This program is used to generate prime numbers upto N (or) check if the given number in a given range is prime or not
*/
import java.util.*;

public class PrimeNumbers{

	static boolean[] primes;
	static int N;

	public static List<Integer> generatePrimesTill(int N){
		List<Integer> primeList = new ArrayList<>();
		primes = new boolean[N+1];
		Arrays.fill(primes, Boolean.true);
		primes[0] = false;
		primes[1] = false;
		
		for(int i=2; i<=Math.sqrt(N); i++){
			if(primes[i]==true){
				for(int j=i*i; j<=N; j+=i){
					primes[j] = false;
				}
			}
		}


		return primeList;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		List<Integer> allPrimes = generatePrimesTill(N);
		System.out.println(list.toString());
		int n = sc.nextInt();
		System.out.println(checkIfPrime(n));		
	}
}