import java.util.*;

public class GenericTreeDistanceBetweenNodes{
	
	private static class Node {
    	int data;
    	ArrayList<Node> children = new ArrayList<>();
  	}

	public static Node construct(int[] arr) {
		Node root = null;

		Stack<Node> st = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
		    	st.pop();
		  	} else {
		    	Node t = new Node();
		    	t.data = arr[i];
		    	if (st.size() > 0) {
		    		st.peek().children.add(t);
		    	} else {
		      		root = t;
		    	}
		    	st.push(t);
			}
		}
		return root;
	}

	public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
    	if (node.data == data) {
      		ArrayList<Integer> path = new ArrayList<>();
      		path.add(node.data);
      		return path;
    	}

	    for (Node child : node.children) {
	    	ArrayList<Integer> ptc = nodeToRootPath(child, data);
	      	if (ptc.size() > 0) {
	        	ptc.add(node.data);
	        	return ptc;
	      	}
	    }
		return new ArrayList<>();
  	}


    public static int distanceBetweenNodes(Node node, int d1, int d2) {
        ArrayList<Integer> path1 = nodeToRootPath(node, d1);
        ArrayList<Integer> path2 = nodeToRootPath(node, d2);
        Collections.reverse(path1);
        Collections.reverse(path2);
        int i=0, j=0, size=0;
        while(i < path1.size() && j < path2.size() && path1.get(i) == path2.get(j)){
        	i++;
        	j++;
        }
        
        while(i < path1.size()){
            size++;
            i++;
        }
        
        while(j < path2.size()){
            size++;
            j++;
        }
        
        return size;
    }

	public static void main(String[] args) {
		
	}
}