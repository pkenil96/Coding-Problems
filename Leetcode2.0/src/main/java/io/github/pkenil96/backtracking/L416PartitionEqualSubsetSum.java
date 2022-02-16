package io.github.pkenil96.backtracking;

import java.util.Arrays;

public class L416PartitionEqualSubsetSum {
    
    public boolean subsetSum(int index, int[] nums, int sum, Boolean[][] memo){
        if(sum == 0){
            return true;
        } 
        if(index == nums.length || sum < 0){
            return false;
        }
        if(memo[index][sum] != null){
            return memo[index][sum];
        } else {
            boolean include = subsetSum(index+1, nums, sum-nums[index], memo);
            boolean exclude = subsetSum(index+1, nums, sum, memo);
            memo[index][sum] = include || exclude;
            return memo[index][sum];
        }
    }
    
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0){
            return false;
        }
        Boolean[][] memo = new Boolean[(nums.length)+1][(sum/2)+1];
        return subsetSum(0, nums, sum/2, memo);
    }
}
