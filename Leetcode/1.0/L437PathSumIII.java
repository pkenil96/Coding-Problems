import java.util.HashMap;
import java.util.Map;

public class L437PathSumIII {
    static int ans;
    
    public static void backtrack(TreeNode root, int target, int sum, Map<Integer, Integer> map){
        if(root == null){
            return;
        }
        sum += root.val;
        if(map.containsKey(sum - target)){
            ans += map.get(sum - target);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        backtrack(root.left, target, sum, map);
        backtrack(root.right, target, sum, map);
        map.put(sum, map.get(sum)-1);
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        backtrack(root, targetSum, 0, map);
        return ans;
    }
}
