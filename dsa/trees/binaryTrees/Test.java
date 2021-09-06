import java.util.*;

class Node{
	int data;
	Node left;
	Node right;

	Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class Test{

	public static boolean dfs(Node root, List<Integer> path, int data){
		if(root == null){
			return false;
		}
		if(root.data == data){
			path.add(root.data);
			return true;
		}
		path.add(root.data);
		if(dfs(root.left, path, data) || dfs(root.right, path, data)){
			return true;
		}
		path.remove(path.size()-1);
		return false;
	}

	public static List<Integer> rootToNodePath(Node root, int data){
		List<Integer> path = new ArrayList<>();
		if(root.data == data){
			path.add(data);
			return path;
		}
		if(dfs(root, path, data)){
			return path;
		}
		System.out.println("Node not found");
		return new ArrayList<Integer>();
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(6);
		root.left.right.left = new Node(7);
		List<Integer> path = rootToNodePath(root, 7);
		for(int node: path){
			System.out.print(node + " ");
		}
		System.out.println();
	}
}