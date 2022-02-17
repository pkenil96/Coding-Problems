import java.util.*;

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