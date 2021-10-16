class L540SingleElementInSortedArray {
    
    public int solution0(int[] nums){
        if(nums.length == 1){
            return nums[0];
        }
        if(nums[nums.length-1] != nums[nums.length-2]){
            return nums[nums.length-1];
        }
        if(nums[0] != nums[1]){
            return nums[0];
        }
        for(int i=1; i<nums.length-1; i++){
            if(nums[i] > nums[i-1] && nums[i] < nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }
    
    public int solution1(int[] nums){
        
    }
    
    public int singleNonDuplicate(int[] nums) {
        return solution0(nums);
    }
}