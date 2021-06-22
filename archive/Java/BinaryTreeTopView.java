package hackerrank;

import java.util.*;

class Node{
    int data;
    Node right;
    Node left;
    Node(int data){
        this.data = data;
    }
}
class Pair<F,S> implements Comparable<Pair>{
    private F first;
    private S second;

    public int compareTo(Pair o){
        return 0;
    }
    public Pair(F first, S second){
        this.first = first;
        this.second = second;
    }
    public F getFirst(){return first;}
    public S getSecond(){return second;}
}

class BinaryTreeTopView{

    public static void printTopView(Node root){

        if(root == null)
            return;

        Queue <Pair<Node,Integer>> q = new PriorityQueue<>();
        Map <Integer,Node> map = new HashMap<>();
        Pair<Node,Integer> p = new Pair<>(root, 0);
        q.add(p);

        while(!q.isEmpty()){
            Pair<Node,Integer> temp = q.peek();
            q.remove();

            if(map.containsKey(temp.getSecond())==true){
                map.put(temp.getSecond(),temp.getFirst());
            } else {
                System.out.println(temp.getFirst().data);
                map.put(temp.getSecond(),temp.getFirst());                
            }

            if(temp.getFirst().left!=null){
                Pair<Node,Integer> left = new Pair<>(temp.getFirst().left, temp.getSecond()-1);
                q.add(left);
            }
            
            if(temp.getFirst().right!=null){
                Pair<Node,Integer> right = new Pair<>(temp.getFirst().right, temp.getSecond()+1);
                q.add(right);
            }
            
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);
        root.left.left = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.left = new Node(10);
        root.right.right.right = new Node(9);
        root.right.right.left.right = new Node(11);
        root.right.right.left.right.right = new Node(12);
        
        printTopView(root);
    }
}
