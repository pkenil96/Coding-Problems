import java.util.*;

class L230KthSmallestInBinaryTree {
    
    static int count;
    static int ans;
    
    public static void inOrder1(TreeNode root, int k, PriorityQueue<Integer> pq){
        if(root == null){
            return;
        }
        inOrder1(root.left, k, pq);
        pq.add(root.val);
        if(pq.size() > k){
            pq.poll();
        }
        inOrder1(root.right, k, pq);
    }
    
    public static void solve(TreeNode root){
        if(root == null){
            return;
        }
        solve(root.left);
        count--;
        if(count == 0){
            ans = root.val;
            return;
        }
        solve(root.right);
        
    }
    
    public int kthSmallest(TreeNode root, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // inOrder1(root, k, pq);
        // return pq.peek();
        count=k; 
        ans=0;
        solve(root);
        return ans;
    }
}