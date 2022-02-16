import java.util.*;

class L163SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        // we iterate through each element and then search for pairs in the 
        // remaining array the gives the closest sum
        int resultSum = 0;
        int diff = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int left = i+1, right=n-1;
            int sum = target-nums[i];
            // the goal is to find the pair that gives sum closest to sum
            while(left < right){
                //diff = Math.min(diff, Math.abs(sum - nums[left] - nums[right]));
                int temp = Math.abs(sum - (nums[left]+nums[right]));
                if(temp < diff){
                    diff = temp;
                    resultSum = nums[i] + nums[left] + nums[right];
                }
                if(nums[left] + nums[right] < sum){
                    left++;
                } else if(nums[left] + nums[right] > sum){
                    right--;
                } else {
                    return target;
                }
            }
        }
        return resultSum;
    }
}