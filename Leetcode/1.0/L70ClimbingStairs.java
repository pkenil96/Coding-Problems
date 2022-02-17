class L70ClimbingStairs {
    
    public static int climbStairsTopDown(int n, Integer[] memo){
        if(n < 0){
            return 0;
        }
        if(n == 0 || n == 1){
            return 1;
        }
        if(memo[n] != null){
            return memo[n];
        } else {
            memo[n] = climbStairsTopDown(n-1, memo) + climbStairsTopDown(n-2, memo);
            return memo[n];
        }
    }
    
    public static int climbStairsBottomUp(int n){
        int[] dp = new int[n+1];
        for(int i=0; i<=n; i++){
            if(i == 0 || i == 1){
                dp[i] = 1;
            } else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }
    
    public int climbStairs(int n) {
        //Integer[] memo = new Integer[n+1];
        //return climbStairsTopDown(n, memo);
        return climbStairsBottomUp(n);
    }
}