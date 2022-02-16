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
class L701InsertInBinarySearchTree {
    
    public static void insertIntoBSTUtil(TreeNode root, int val){
        TreeNode temp = root;
        while(true){
            if(temp.val > val){
                if(temp.left == null){
                    temp.left = new TreeNode(val);
                    return;
                } else {
                    temp = temp.left;
                }
            } else if(temp.val < val){
                if(temp.right == null){
                    temp.right = new TreeNode(val);
                    return;
                } else {
                    temp = temp.right;
                }
            }
        }
    }
    
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        insertIntoBSTUtil(root, val);
        return root;
    }
}