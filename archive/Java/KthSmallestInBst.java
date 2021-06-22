package leetcode;
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
class KthSmallestInBst {
    
    public int kthSmallest(TreeNode root, int k) {
        //doing inorder traversal iteratively and returning the root when the kth iteration is reached
        if(root == null)
            return -1;
        
        Stack <TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        int count = 0;
        while(curr != null || stack.size() > 0 ){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            count++;
            curr = stack.pop();
            //print the node
            if(count == k)
                return curr.val;
            curr = curr.right;
        }
        return -1;
    }
}