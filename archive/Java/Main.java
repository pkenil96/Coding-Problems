package trees;

import java.util.ArrayList;

class Main{
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.insert(1);
		bt.insert(2);
		bt.insert(3);
		bt.insert(4);
		bt.insert(5);
		bt.insert(6);
		bt.insert(7);
		bt.insert(8);
		bt.insert(9);
		bt.insert(10);
		ArrayList <Integer> nodes = bt.getNodesForLevel(2);		
		for(Integer it : nodes) {
			System.out.print(it + " ");
		}
	}
}