import java.util.*;

class L78Subsets {
    
    public void dfs(int[] nums, List<Integer> list, List<List<Integer>> ans, int index){
        
        if(index == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        // left branch: item at index is included and we recurse for remaining elements
        list.add(nums[index]);
        dfs(nums, list, ans, index+1);
        
        // right branch: item at index is excluded and we recurse for remaining elements
        list.remove(list.size()-1);
        dfs(nums, list, ans, index+1);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, new ArrayList<>(), ans, 0);
        return ans;
    }
}