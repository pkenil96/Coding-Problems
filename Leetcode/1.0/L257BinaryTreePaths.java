import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class L257BinaryTreePaths {
    
    public static void getAllPaths(TreeNode root, String path, List<String> paths){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            path+=root.val;
            paths.add(path);
            return;
        }
        path+=root.val+"->";
        getAllPaths(root.left, path, paths);
        getAllPaths(root.right, path, paths);
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<String> paths = new ArrayList<>();
        getAllPaths(root, "", paths);
        return paths;
    }
}