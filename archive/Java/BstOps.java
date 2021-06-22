package codechef;

import java.util.*;
import java.lang.*;
import java.io.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    int position;
    
    //default constructor
    TreeNode(){}
    
    TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.position = -1;
    }
}

class Bst{
    TreeNode root = null;

    public int insert(int data){
        TreeNode newNode = new TreeNode(data);

        if(root == null){
            root = newNode;
            newNode.position = 1;
            return newNode.position;
        } else {
            TreeNode runner = root;
            TreeNode previous = null;
            while(runner != null){
                previous = runner;
                if(runner.data > data){
                    runner = runner.left;
                } else {
                    runner = runner.right;
                }
            }
            if(previous.data > data){
                previous.left = newNode;
                newNode.position = previous.position * 2;
                return newNode.position;
            } else {
                previous.right = newNode;
                newNode.position = previous.position * 2 + 1;
                return newNode.position;
            }
        }
    }//end of Bst.add(...)

    public TreeNode search(int data){
        if(root.data == data)
            return root;

        TreeNode runner = root;
        while(runner != null && runner.data != data){
            if(runner.data < data){
                runner = runner.right;
            } else {
                runner = runner.left;
            }
        }
        if(runner != null)
            return runner;
        return null;// node not found
    } //end of Bst.search(...)


    // removes the node from the bst and returns the position of the deleted node
    public int remove(int data){
        if(root == null){
            System.out.println("ERROR: Deletion on empty tree");
            return -1;
        } else {
            TreeNode runner = root;
            TreeNode parent = null;
            
            return -1;
        }
    } // end of Bst.remove(...)
    
}//end of class Bst

/* Name of the class has to be "Main" only if the class is public. */
public class BstOps{
	public static void main (String[] args) throws java.lang.Exception{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int Q = sc.nextInt();
		Bst bst = new Bst();
        for(int i=0; i<Q; i++){
            char op = sc.next().charAt(0);
            if(op == 'i'){
                int idata = sc.nextInt();
                System.out.println(bst.insert(idata));
            } else if(op == 'd') {
                int rdata = sc.nextInt();
                System.out.println(bst.remove(rdata));
            } else {
                System.out.println("ERROR: Operation not supported!");
            }
		}
	}
}
