/*
Following is the algorithm to find all the prime numbers less than or equal to a given integer n by Eratosthenes’ method:

1) Create a list of consecutive integers from 2 to n: (2, 3, 4, …, n). Initially, let p equal 2, the first prime number.
2) Starting from p2, count up in increments of p and mark each of these numbers greater than or equal to p2 itself in the list. These numbers will be p(p+1), p(p+2), p(p+3), etc..
3) Find the first number greater than p in the list that is not marked. If there was no such number, stop. Otherwise, let p now equal this number (which is the next prime), and repeat from step 3.

When the algorithm terminates, all the numbers in the list that are not marked are prime.
*/

class PrimeNumberGenerator{
    public static void main(String [] args){
        if(args.length != 1){
            System.out.println("Usage : PrimeNumberGnerator <n>");
            System.exit(-1);
        }
        int N = Integer.parseInt(args[0]);
        
        int [] primes = new int[N+1];
        //notations: 1 - prime; 0 - not prime
        //initially all the numbers are marked as prime
        for(int i=2; i<N; i++)
            primes[i] = 1;
            
        for(int i=2; i<N; i++){
            if(primes[i] == 1){
                for(int j=i*i; j<N; j+=i)
                    primes[j] = 0;
            }
        }
        
        for(int i=2; i<N; i++){
            if(primes[i] == 1)
                System.out.print(i + " ");
        }
        System.out.println();               
    }
}
