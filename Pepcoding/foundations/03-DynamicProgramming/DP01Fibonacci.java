/*
	https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/fibonacci-dp-official/ojquestion
*/

import java.util.Scanner;

public class DP01Fibonacci{

	public static int fibBruteForce(int n){
		if(n == 0 || n == 1){
			return n;
		}
		return fibBruteForce(n-1)+fibBruteForce(n-2);
	}

	public static int fibTopDown(int n, Integer[] dp){
        if(n == 0 || n == 1){
            return n;
        }
        if(dp[n] != null){
            return dp[n];
        } else {
            dp[n] = fibMemoization(n-1, dp) + fibMemoization(n-2, dp);
            return dp[n];
        }
    }

    public static int fibBottomUp(int n){
    	int[] dp = new int[n+1];
    	dp[0] = 0;
    	dp[1] = 1;
    	for(int i=2; i<=n; i++){
    		dp[i] = dp[i-1] + dp[i-2];
    	}
    	return dp[n];
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] dp = new Integer[n+1];
        
        // brute force solution
        // System.out.println(fibBruteForce(n));
        // solution using memoization - top down
        // System.out.println(fibTopDown(n, dp));
        // solution using tabulation - bottom up
        System.out.println(fibBottomUp(n));
    }
}