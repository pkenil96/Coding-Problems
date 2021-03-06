import java.util.*;

class L107BinaryTreeLevelOrderTraversalII {
    List<List<Integer>> result = new ArrayList<>();
        
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            while(size > 0){
                size--;
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            result.add(0, temp);
        }
        //Collections.reverse(result);
        return result;
    }
}