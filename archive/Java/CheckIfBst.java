package trees;

import java.util.Random;

public class CheckIfBst{
	
	public static void main(String [] args) {
		//tree 1: populating 10 random elements into the binary tree
		Random rd = new Random();
		
		BinaryTree nonBst = new BinaryTree();
		for(int i=1; i<7; i++) {
			int randInt = rd.nextInt(50);
			int insertPos = nonBst.insert(randInt);
			System.out.println(randInt + " inserted at position " + insertPos );
		}
		System.out.println(nonBst.isBst());
		System.out.println();
		
		//tree 2: populating in such a way that resultant tree is bst
		BinaryTree bst = new BinaryTree();
		int [] bstItems = {13, 9, 16, 4, 10, 14, 80};
		for(int i=0; i<bstItems.length; i++) {
			int insertPos = bst.insert(bstItems[i]);
			System.out.println(bstItems[i] + " inserted at position " + insertPos );
		}
		System.out.println(bst.isBst());	
	}
}