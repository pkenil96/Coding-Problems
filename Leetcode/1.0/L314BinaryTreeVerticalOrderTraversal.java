import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class L314BinaryTreeVerticalOrderTraversal {
    
    static class Pair {
        int value;
        int row;
        
        Pair(int value0, int row0){
            value = value0;
            row = row0;
        }
    }
    // we keep track of the minCol and maxCol to avoid using TreeMap and get the job dones
    // with HashMap itself. Since columns are continuos, we can start iterating from minCol
    // all the way up to maxCol to ensure that we go collecting nodes from left to right columnwise
    
    static int minCol;
    static int maxCol;
    
    public static void collectNodes(TreeNode root, HashMap<Integer, List<Pair>> map, int row, int col){
        if(root == null){
            return;
        }
        minCol = Math.min(minCol, col);
        maxCol = Math.max(maxCol, col);
        List<Pair> temp = map.getOrDefault(col, new ArrayList<>());
        temp.add(new Pair(root.val, row));
        map.put(col, temp);
        collectNodes(root.left, map, row+1, col-1);
        collectNodes(root.right, map, row+1, col+1);
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        minCol = Integer.MAX_VALUE;
        maxCol = Integer.MIN_VALUE;
        
        int beginRow=0;
        int beginCol=0;
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, List<Pair>> map = new HashMap<>();
        collectNodes(root, map, beginRow, beginCol);
        
        for(int col=minCol; col<=maxCol; col++){
            List<Pair> nodes = map.get(col);
            Collections.sort(nodes, (p1, p2) -> p1.row - p2.row);
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<nodes.size(); i++){
                temp.add(nodes.get(i).value);
            }
            result.add(temp);
        }
        return result;
    }
}