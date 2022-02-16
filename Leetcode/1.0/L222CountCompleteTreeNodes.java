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
class L222CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftSubtreeNodeCount = countNodes(root.left);
        int rightSubTreeNodeCount = countNodes(root.right);
        return 1+leftSubtreeNodeCount+rightSubTreeNodeCount;
    }
}