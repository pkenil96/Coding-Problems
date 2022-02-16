class L370RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        
        // brute force
        /*for(int i=0; i<updates.length; i++){
            int start = updates[i][0];
            int end = updates[i][1];
            int val = updates[i][2];
            for(int j=start; j<=end; j++){
                nums[j] += val;
            }
        }
        return nums;*/
        
        // optimized
        int[] prefix = new int[length];
        for(int i=0; i<updates.length; i++){
            int start = updates[i][0];
            int end = updates[i][1];
            int val = updates[i][2];
            nums[start] += val;
            if(end+1 < length){
                nums[end+1] -= val;
            }
        }
        prefix[0] = nums[0];
        for(int i=1; i<length; i++){
            prefix[i] = nums[i] + prefix[i-1];
        }
        return prefix;
    }
}