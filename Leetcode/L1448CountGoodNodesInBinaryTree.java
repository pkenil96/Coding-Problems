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
class L1448CountGoodNodesInBinaryTree {
    
    static int ans;
    
    public static void countGoodNodes(TreeNode root, int maxVal){
        if(root == null){
            return;
        }
        if(root.val >= maxVal){
            ans++;
            maxVal = root.val;
        }
        countGoodNodes(root.left, maxVal);
        countGoodNodes(root.right, maxVal);
    }
    
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        ans=0;
        countGoodNodes(root, root.val);
        return ans;
    }
}