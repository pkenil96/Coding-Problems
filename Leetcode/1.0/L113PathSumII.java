import java.util.*;

public class L113PathSumII {
    public void backtrack(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result){
        if(root == null){
            return;
        }
        path.add(root.val);
        if(root.left == null && root.right == null && sum-root.val == 0){
            result.add(new ArrayList<>(path));
        } else {
            backtrack(root.left, sum-root.val, path, result);
            backtrack(root.right, sum-root.val, path, result);
        }
        path.remove(path.size()-1); // backtracking step (when both left and subtrees have been visited)
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(root, targetSum, new ArrayList<>(), result);
        return result;
    }
}
