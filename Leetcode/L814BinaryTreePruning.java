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
class L814BinaryTreePruning {
    
    public static boolean containsOne(TreeNode root){
        if(root == null){
            return false;
        }
        if(root.val == 1){
            return true;
        }
        return containsOne(root.left) || containsOne(root.right);
    }
    
    public TreeNode pruneTree(TreeNode root) {
        if(root == null){
            return root;
        }
        if(containsOne(root.left) == false){
            root.left = null;
        }
        if(containsOne(root.right) == false){
            root.right = null;
        }
        pruneTree(root.left);
        pruneTree(root.right);
        
        if(root.left == null && root.right == null && root.val == 0){
            return null;
        }
        return root;
    }
}