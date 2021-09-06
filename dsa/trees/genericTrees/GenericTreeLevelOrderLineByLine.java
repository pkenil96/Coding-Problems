import java.io.*;
import java.util.*;

public class GenericTreeLevelOrderLineByLine {
    
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

  
    public static void levelOrderLinewise(Node node){
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                Node curr = q.poll();
                for(Node child: curr.children){
                    q.add(child);
                }
                size--;
                System.out.print(curr.data + " ");
            }
            System.out.println();
        }    
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
          arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        levelOrderLinewise(root);
    }
}