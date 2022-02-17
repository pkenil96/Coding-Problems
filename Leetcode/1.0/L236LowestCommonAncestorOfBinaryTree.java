import java.util.*;


class L236LowestCommonAncestorOfBinaryTree {
    
    public boolean getRootToNodePathUtil(TreeNode root, TreeNode des, List<TreeNode> path){
        if(root == null){
            return false;
        }
        if(root.val == des.val){
            path.add(root);
            return true;
        }
        path.add(root);
        if(getRootToNodePathUtil(root.left, des, path) || getRootToNodePathUtil(root.right, des, path)){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    
    public List<TreeNode> getRootToNodePath(TreeNode root, TreeNode des){
        List<TreeNode> path = new ArrayList<>();
        getRootToNodePathUtil(root, des, path);
        return path;
    }
    
    // we find root to node path for both the nodes and then find the
    // first common node in the path while traversing from root to node path
    public TreeNode method0(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }
        List<TreeNode> path1 = getRootToNodePath(root, p);
        List<TreeNode> path2 = getRootToNodePath(root, q);
        int index = 0;
        TreeNode lca = null;
        while(index < path1.size() && index < path2.size()){
            if(path1.get(index).val == path2.get(index).val){
                lca = path1.get(index);
            } else {
                return lca;
            }
            index++;
        }
        return lca;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return method0(root, p, q);   
    }
}