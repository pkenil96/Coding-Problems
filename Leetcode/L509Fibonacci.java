class L509Fibonacci {
    
    public static int fibBruteForce(int n){
        if(n == 0 || n == 1){
            return n;
        }
        return fibBruteForce(n-1)+fibBruteForce(n-2);
    }

    public static int fibTopDown(int n, Integer[] memo){
        if(n==0||n==1){
            return n;
        }
        if(memo[n] != null){
            return memo[n];
        } else {
            memo[n] = fibTopDown(n-1, memo) + fibTopDown(n-2, memo);
            return memo[n];
        }
    }
    
    public static int fibBottomUp(int n){
        if(n == 0){
            return 0;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    
    public int fib(int n) {
        // TOP DOWN APPROACH (MEMOIZATION)
        // Integer[] memo = new Integer[n+1];
        // return fibTopDown(n, memo);
        
        // BOTTOM UP APPROACH (TABULATION)
        return fibBottomUp(n);
    }
}