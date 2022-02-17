import java.util.*;

class L863AllNodesDistanceKInBinaryTree {
    
    private boolean getNodeToRootPathUtil(TreeNode root, int target, List<TreeNode> path){
        if(root == null){
            return false;
        }
        if(root.val == target){
            path.add(0, root);
            return true;
        }
        
        // adding the current node to the path and exploring the right and the left subtree
        path.add(0, root);
        
        boolean foundInLeftSubTree = getNodeToRootPathUtil(root.left, target, path);
        if(foundInLeftSubTree){
            return true;
        }
        
        boolean foundInRightSubTree = getNodeToRootPathUtil(root.right, target, path);
        if(foundInRightSubTree){
            return true;
        }
        // in case we don't find the node either in the right subtree or the left
        // subtree we delete that node from the path and return false
        path.remove(0);
        return false;        
    }
    
    // returns the path from the target node to the root
    private List<TreeNode> getNodeToRootPath(TreeNode root, int target){
        List<TreeNode> path = new LinkedList<>();
        getNodeToRootPathUtil(root, target, path);
        return path;
    }
    
    
    private void getNodesKLevelsDownUtil(TreeNode node, int k, TreeNode blocker, List<Integer> res){
        if(node == null || node == blocker || k < 0){
            return;
        }
        if(k == 0){
            res.add(node.val);
            return;
        }
        getNodesKLevelsDownUtil(node.left, k-1, blocker, res);
        getNodesKLevelsDownUtil(node.right, k-1, blocker, res);
    }
    
    // returns all the nodes that are k levels down from node. In case a blocker
    // node is found while exploring, the search terminates from that point
    private List<Integer> getNodesKLevelsDown(TreeNode node, int k, TreeNode blocker){
        List<Integer> nodes = new ArrayList<>();
        getNodesKLevelsDownUtil(node, k, blocker, nodes);
        return nodes;
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // we first get the node to root path
        List<TreeNode> pathNodes = getNodeToRootPath(root, target.val);
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<pathNodes.size(); i++){
            if(i == 0){
                result.addAll(getNodesKLevelsDown(pathNodes.get(i), k-i, null));
            } else {
                result.addAll(getNodesKLevelsDown(pathNodes.get(i), k-i, pathNodes.get(i-1)));
            }
        }
        return result;
    }
}