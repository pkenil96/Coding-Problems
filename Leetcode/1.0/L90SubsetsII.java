// https://www.youtube.com/watch?v=Vn2v6ajA7U0
import java.util.*;

class L90SubsetsII {
    
    static Set<String> set;
    
    public void dfs2(int[] nums, List<Integer> list, List<List<Integer>> result, int index){
        if(index == nums.length){
            List<Integer> list2 = new ArrayList<>(list);
            Collections.sort(list2);
            String temp = list2.toString();
            if(set.contains(temp)){
                return;
            } else {
                set.add(temp);
                result.add(new ArrayList<>(list));
                return;
            }
        }
        list.add(nums[index]);
        dfs2(nums, list, result, index+1);
        
        list.remove(list.size()-1);
        dfs2(nums, list, result, index+1);
    }
    
    public void dfs(int[] nums, List<Integer> list, List<List<Integer>> result, int index){
        if(index == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        // left branch: we include element at index=index
        list.add(nums[index]);
        dfs(nums, list, result, index+1);
        
        // right branch: we exclude element at index
        list.remove(list.size()-1);
        // before we recurse in the right branch, we make sure to skip all the duplicates
        while(index+1 < nums.length && nums[index] == nums[index+1]) index++;
        dfs(nums, list, result, index+1);
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), ans, 0);
        //dfs2(nums, new ArrayList<>(), ans, 0);
        return ans;
    }
}