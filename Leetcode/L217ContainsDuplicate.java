class L217ContainsDuplicate {
    
    public static boolean method1(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
    
    public static boolean method2(int[] nums){
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }
    
    public boolean containsDuplicate(int[] nums) {
        //return method1(nums);
        return method2(nums);
    }
}