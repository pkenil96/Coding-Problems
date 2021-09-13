import java.util.Scanner;
import java.util.ArrayList;

class TreeNode{
	int data;
	int nodeSum;
	TreeNode left;
	TreeNode right;

	TreeNode(int data){
		this.data = data;
		this.nodeSum = 0;
		this.left = null;
		this.right = null;
	}
}


public class SubtreeSum{

	static int maxVal;

	public static int subTreeSum(TreeNode root){
		int sum = 0;

		if(root.left != null){
			sum+=subTreeSum(root.left);
		}
		if(root.right != null){
			sum+=subTreeSum(root.right);
		}
		sum += root.data;
		root.nodeSum = sum;
		return sum;
	}

	public static int findMaxVal(TreeNode root){
		int sum = 0;

		if(root.left != null){
			sum+=subTreeSum(root.left);
		}
		if(root.right != null){
			sum+=subTreeSum(root.right);
		}
		sum += root.data;
		maxVal = Math.max(maxVal, sum);
		// root.nodeSum = sum;
		return sum;	
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		subTreeSum(root);

		System.out.println(root.data + "@" + root.nodeSum);
		System.out.println(root.left.data  + "@" +  root.left.nodeSum);
		System.out.println(root.right.data + "@" + root.right.nodeSum);
		System.out.println(root.left.left.data + "@" + root.left.left.nodeSum);
		System.out.println(root.left.right.data + "@" + root.left.right.nodeSum);
		System.out.println(root.right.left.data + "@" + root.right.left.nodeSum);
		System.out.println(root.right.right.data + "@" + root.right.right.nodeSum);

		maxVal = Integer.MIN_VALUE;
		findMaxVal(root);
		System.out.println("Max sum is: " + maxVal);
	}
}