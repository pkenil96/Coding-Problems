/*
	https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/fibonacci-dp-official/ojquestion
*/

import java.util.Scanner;

public class Fibonacci{

	public static int fibMemoization(int n, Integer[] dp){
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


    public static int fibTabulation(int n){

    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] dp = new Integer[n+1];
        
        // solution using memoization - top down
        System.out.println(fibMemoization(n, dp));
        // solution using tabulation - bottom up
        System.out.println(fibTabulation(n));
    }
}