/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class L1022SumOfRootToLeafBinaryNumbers {
    
    static int ans;
    
    public static void solve(TreeNode root, String snum){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            snum+=root.val;
            ans += Integer.parseInt(snum, 2);
            return;
        }
        solve(root.left, snum+root.val);
        solve(root.right, snum+root.val);
    }
    
    public int sumRootToLeaf(TreeNode root) {
        if(root == null){
            return 0;
        }
        ans = 0;
        solve(root, "");
        return ans;
    }
}