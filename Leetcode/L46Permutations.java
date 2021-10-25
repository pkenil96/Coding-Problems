class L46Permutations {
    
    public static void permuteUsingSwap(int index, List<Integer> nums, List<List<Integer>> result){
        if(index == nums.size()-1){
            result.add(new ArrayList<>(nums));
            return;
        }
        for(int i=index; i<nums.size(); i++){
            Collections.swap(nums, i, index);
            permuteUsingSwap(index+1, nums, result);
            Collections.swap(nums, i, index);
        }
    }

    public void permuteUsingSet(int[] nums, List<Integer> temp, List<List<Integer>> result){
        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(temp.contains(nums[i])){
                continue;
            }
            temp.add(nums[i]);
            permuteUsingSet(nums, temp, result);
            temp.remove(temp.size()-1);
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteUsingSet(nums, new ArrayList<>(), result);
        /*List<Integer> list = new ArrayList<>();
        for(int num: arr){
            list.add(num);
        }
        permuteUsingSwap(0, list, result);*/
        return result;
    }
}