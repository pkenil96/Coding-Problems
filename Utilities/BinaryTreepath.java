import java.util.List;
import java.util.ArrayList;

public class BinaryTreepath {
	
	static class TreeNode{
		private int val;
		private TreeNode left;
		private TreeNode right;
		
		TreeNode(int val){
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	private static List<Integer> path;
	
	public static void rootToNodePathUtil(TreeNode root, int val, List<Integer> tempPath) {
		if(root == null) {
			return;
		}
		tempPath.add(root.val);
		if(root.val == val) {
			path = new ArrayList<>(tempPath);
			return;
		} else {
			rootToNodePathUtil(root.left, val, tempPath);
			rootToNodePathUtil(root.right, val, tempPath);
			tempPath.remove(tempPath.size()-1);
		}
		
	}
	
	public static List<Integer> rootToNodePath(TreeNode root, int val){
		List<Integer> path = new ArrayList<>();
		rootToNodePathUtil(root, val, new ArrayList<>());
		return path;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		rootToNodePath(root, 7);
		for(Integer node: path) {
			System.out.println(node);
		}
	}

}
