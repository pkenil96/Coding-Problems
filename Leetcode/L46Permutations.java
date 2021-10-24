class L46Permutations {
    
    public void backtrack(int[] nums, List<Integer> temp, List<List<Integer>> result){
        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(temp.contains(nums[i])){
                continue;
            }
            temp.add(nums[i]);
            backtrack(nums, temp, result);
            temp.remove(temp.size()-1);
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }
}