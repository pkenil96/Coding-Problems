import java.util.*;

class L987VerticalOrderTraversalOfBinaryTree {
    
    private static int max;
    private static int min;
    
    private static class Node{
        int data;
        int row;
        
        Node(int data, int row){
            this.data = data;
            this.row = row;
        }
    }
    
    private static void dfs(TreeNode root, Map<Integer, List<Node>> map, int row, int col){
        if(root == null){
            return;
        }
        min = Math.min(min, col);
        max = Math.max(max, col);
        map.putIfAbsent(col, new ArrayList<>());
        map.get(col).add(new Node(root.val, row));
        dfs(root.left, map, row+1, col-1);
        dfs(root.right, map, row+1, col+1);
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        Map<Integer, List<Node>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, map, 0, 0);
        
        for(int i=min; i<=max; i++){
            List<Node>nodes = map.get(i);
            Collections.sort(nodes, (e1, e2) -> {
                if(e1.row == e2.row) 
                    return e1.data - e2.data;
                return e1.row - e2.row;
            });
            List<Integer> list = new ArrayList<>();
            for(Node node: nodes){
                list.add(node.data);
            }
            res.add(list);
        }
        return res;
    }
}