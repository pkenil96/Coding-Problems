class L209MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int i=0, j=0, sum=0, n=nums.length;
        while(i < n && j < n){
            sum += nums[j];
            if(sum < target){
                j++;
            } else {
                while(i < n && sum >= target){
                    minLength = Math.min(minLength, j-i+1);
                    sum -= nums[i];
                    i++;
                }
                j++;
            }
        }
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}