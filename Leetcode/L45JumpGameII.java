public class L45JumpGameII {
    
    public int bruteForce(int[] nums, int index){
        if(index == nums.length-1){
            return 0;
        }
        if(index >= nums.length){
            return 99999;
        }
        int minWays = 99999;
        for(int i=1; i<=nums[index]; i++){
            int ways = bruteForce(nums, index + i);
            minWays = Math.min(minWays, 1+ways);
        }
        return minWays;
    }
    
    public int topDown(int[] nums, int index, Integer[] memo){
        if(index >= nums.length-1){
            return 0;
        }
        if(memo[index] != null){
            return memo[index];
        } else {
            int minWays = 99999;
            for(int i=1; i<=nums[index]; i++){
                int ways = topDown(nums, index + i, memo);
                minWays = Math.min(minWays, 1+ways);
            }
            memo[index] = minWays;
            return memo[index];
        }
    }
    
    public int bottomUp(int[] nums){
       int n = nums.length;
        int[] dp = new int[n];
        dp[n-1] = 0;
        for(int i=n-2; i>=0; i--){
            int minWays = 99999;
            for(int j=1; j<=nums[i] && i+j<n; j++){
                minWays = Math.min(minWays, dp[i+j]);
            }
            dp[i] = minWays + 1;
        }
        return dp[0]; 
    }
    
    public int jump(int[] nums) {
        //return bruteForce(nums, 0);
        //Integer[] memo = new Integer[nums.length+1];
        //return topDown(nums, 0, memo);
        return bottomUp(nums);
    }
}