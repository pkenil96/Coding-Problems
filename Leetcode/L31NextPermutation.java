class L31NextPermutation {
    public void nextPermutation(int[] nums) {
        int index1 = -1;
        // finding the first index(index1) from right where nums[index1] < nums[index1+1]
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                index1 = i;
                break;
            }
        }
        
        int temp;
        // if index1 is -1, reverse nums and return
        if(index1 == -1){
            for(int i=0, j=nums.length-1; i<=j; i++, j--){
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            return;
        }
        
        // finding the index(index2) from right such that index2 > index1 && a[index1] < a[index2]
        int index2 = -1;
        for(int i=nums.length-1; i>index1; i--){
            if(nums[i] > nums[index1]){
                index2 = i;
                break;
            }
        }

        // swap nums[index1] and nums[index2]
        temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
        
        // reverse the subarray nums[index1+1:]
        for(int i=index1+1, j=nums.length-1; i<=j; i++, j--){
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}