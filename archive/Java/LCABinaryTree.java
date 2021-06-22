package leetcode;

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode(int data){
		this.data = data;
	}
}

class LCABinaryTree{

	public static TreeNode LCABinaryTreeUtil(TreeNode root, int a, int b){
		if(root == null)
			return root;
		if(root.data == a || root.data == b) 
			return root;

		TreeNode leftLca = LCABinaryTreeUtil(root.left, a, b);
		TreeNode rightLca = LCABinaryTreeUtil(root.right, a, b);

		if(leftLca!=null && rightLca!=null)
			return root;

		return (leftLca!=null)?leftLca:rightLca;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println(LCABinaryTreeUtil(root, 6,7).data);

	}
}