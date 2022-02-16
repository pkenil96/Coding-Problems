import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class L508MostFrequentSubtreeSum {
    
    static int maxCount;
    
    public static int backtrack(TreeNode root, HashMap<Integer, Integer> map){
        if(root == null){
            return 0;
        }
        int leftSubTreeSum = backtrack(root.left, map);
        int rightSubTreeSum = backtrack(root.right, map);
        int total = root.val + leftSubTreeSum + rightSubTreeSum;
        int count = map.getOrDefault(total, 0)+1;
        map.put(total, count);
        maxCount = Math.max(maxCount, count);
        return total;
    }
    
    public int[] findFrequentTreeSum(TreeNode root) {
        maxCount = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        backtrack(root, map);
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            if(val == maxCount){
                list.add(key);
            }
        }
        int[] ans = new int[list.size()];
        for(int i=0; i<ans.length; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}