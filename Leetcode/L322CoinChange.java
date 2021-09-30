class L322CoinChange {
    
    public static int bruteForce(int[] nums, int amt, int index){
        if(amt == 0){
            return 0;
        }
        if(index >= nums.length || amt < 0){
            return 99999;
        }
        int include = 1+bruteForce(nums, amt-nums[index], index);
        int exclude = bruteForce(nums, amt, index+1);
        return Math.min(include, exclude);
    }
    
    public static int topDown(int[] nums, int amt, int index, Integer[][] memo){
        if(amt == 0){
            return 0;
        }
        if(index >= nums.length || amt < 0){
            return 99999;
        }
        if(memo[index][amt] != null){
            return memo[index][amt];
        } else {
            int include = 1+topDown(nums, amt-nums[index], index, memo);
            int exclude = topDown(nums, amt, index+1, memo);
            memo[index][amt] = Math.min(include, exclude); 
            return memo[index][amt];
        }
        
    }
    
    public static int bottomUp(int[] nums, int amt){
        if(amt == 0){
            return 0;
        }
        int[][] dp = new int[nums.length+1][amt+1];
        // base cases
        
        for(int i=0; i<=amt; i++){
            dp[0][i] = 99999;
        }
        
        
        for(int i=0; i<=nums.length; i++){
            dp[i][0] = 0;
        }
    
        for(int i=1; i<=nums.length; i++){
            for(int j=1; j<=amt; j++){
                if(nums[i-1] > j){
                    dp[i][j] = dp[i-1][j];        
                } else {
                    dp[i][j] = Math.min(1+dp[i][j-nums[i-1]], dp[i-1][j]);
                }
            }
        }
        return dp[nums.length][amt] >= 99999?-1:dp[nums.length][amt];
    }
    
    public int coinChange(int[] coins, int amount) {
        //int res = bruteForce(coins, amount, 0);
        //return res == 99999?-1:res;
        
        //Integer[][] memo = new Integer[coins.length+1][amount+1];
        //int res = topDown(coins, amount, 0, memo);
        //return res == 99999?-1:res;
        return bottomUp(coins, amount);
    }
}