import java.util.*;

class L199BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size(), prev=0;
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
                prev = curr.val;
            }
            result.add(prev);
        }
        //Collections.reverse(result);
        return result;
    }
}