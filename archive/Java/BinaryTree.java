package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree{
	/*made accessible only to the BinaryTree; enforces OOP principle*/
	private class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		//keeps track of the position where the node was inserted
		int position;

		TreeNode(int data){
			this.data = data;
			left = null;
			right = null;
			position = -1;
		}
	}

	//if debug set to true, logs of each operations would be displayed on the console
	private boolean insertDebug;
	private boolean deleteDebug;

	public BinaryTree(){
		insertDebug = false;
		deleteDebug = false;
	}

	TreeNode root = null;

	// log related public methods
	public void enableInsertLogs(){
		insertDebug = true;
		System.out.println("Insertion Logs enabled!");
	}

	public void enableDeleteLogs(){
		deleteDebug = true;
		System.out.println("Deletion Logs enabled!");
	}

	public void displayInsertLogs(int data, int position){
		System.out.println("New node added: Value = " + data + " Position = " + position);
	}

	public void displayDeleteLogs(int data, int position){
		System.out.println("Node removed: Value = " + data + " Position = " + position);
	}

	
	private boolean isBstUtil(TreeNode root, int min, int max) {
		if(root == null) return true;
		if(root.data < min || root.data > max) return false;
		return (isBstUtil(root.left, min, root.data - 1) && isBstUtil(root.right, root.data + 1, max));
	}
	
	public boolean isBst() {
		return isBstUtil(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public ArrayList<Integer> getNodesForLevel(int level) {
		if(level < 0)
			return null;
		ArrayList <Integer> nodes = new ArrayList<>();
		Queue <TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		
		int currentLevel = 0; //root's level
		while(!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			if(curr == null) {
				if(!queue.isEmpty()) {
					queue.add(null);
					currentLevel++;
				}
			} else {
				if(curr.left != null)
					queue.add(curr.left);
				if(curr.right != null)
					queue.add(curr.right);
				if(currentLevel == level)
					nodes.add(curr.data);
			}
		}
		return nodes;
	}
	
	public void printByLevel(){
		if(root == null) return;

		Queue <TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);

		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();
			if(temp == null) {
				if(!queue.isEmpty()) {
					queue.add(null);
					System.out.println();
				}
			} else {
				if(temp.left != null)
					queue.add(temp.left);
				if(temp.right != null)
					queue.add(temp.right);
				System.out.print(temp.data + " ");
			}
		}
	}// end of printByLevel

	//insertion takes place in level order fashion
	public int insert(int data){
		TreeNode newNode = new TreeNode(data);
		if(root == null){ //first node in the binary tree
			root = newNode;
			newNode.position = 1;
			if(insertDebug == true) displayInsertLogs(data, newNode.position);
			return newNode.position;
		}
		//we insert the new node in level order fashion
		Queue <TreeNode> queue = new LinkedList<>();
		TreeNode helper = root;
		queue.add(helper);

		while(!queue.isEmpty()){
			helper = queue.peek();
			queue.remove();

			if(helper.left == null){
				helper.left = newNode;
				newNode.position = helper.position * 2;
				if(insertDebug == true) displayInsertLogs(data, newNode.position);
				return newNode.position;
			} else {
				queue.add(helper.left);
			}

			if(helper.right == null){
				helper.right = newNode;
				newNode.position = helper.position * 2 + 1;
				if(insertDebug == true) displayInsertLogs(data, newNode.position);
				return newNode.position;
			} else {
				queue.add(helper.right);
			}
		}
		return -1;
	}
} 