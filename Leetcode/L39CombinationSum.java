class L39CombinationSum {
    
    private void solve(int[] nums, int target, List<List<Integer>> result, int index, List<Integer> temp){
        if(target == 0){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(index >= nums.length || target < 0){
            return;
        }
        for(int i=index; i<nums.length; i++){
            temp.add(nums[i]);
            solve(nums, target-nums[i], result, i, temp);
            temp.remove(temp.size()-1);
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        solve(candidates, target, result, 0, new ArrayList<>());
        return result;
    }
}