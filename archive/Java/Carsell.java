package codechef;

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Carsell{
	public static void main (String[] args) throws java.lang.Exception{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t; 
		if(sc.hasNext())
			t = sc.nextInt();
		int n = sc.nextInt();
		Integer [] prices = new Integer[n];
		for(int i=0; i<n; i++){
			prices[i] = sc.nextInt();
		}
		Arrays.sort(prices, Collections.reverseOrder());
		long ans = prices[0];
		for(int i=1; i<n; i++){
			int curr_val = prices[i] - i;
			curr_val = (curr_val < 0)?0:curr_val;
			ans += curr_val;
		}
		System.out.println(ans%10000007);
	}
}
