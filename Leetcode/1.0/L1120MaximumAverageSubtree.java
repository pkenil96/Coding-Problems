import java.util.*;

class Pair1120{
    double sum;
    double count;
    Pair1120(double sum, double count){
        this.sum = sum;
        this.count = count;
    }
}

class L1120MaximumAverageSubtree {
    
    public int findSum(TreeNode root, HashMap<TreeNode, Integer> map){
        if(root == null){
            return 0;
        }
        int nodeSum = root.val + findSum(root.left, map) + findSum(root.right, map);
        map.put(root, nodeSum);
        return nodeSum;
    }
    
    public int findNodes(TreeNode root, HashMap<TreeNode, Integer> map){
        if(root == null){
            return 0;
        }
        int nodeCount = 1 + findNodes(root.left, map) + findNodes(root.right, map);
        map.put(root, nodeCount);
        return nodeCount;
    }
    
    static double gmax;
    
    public Pair1120 maximumAverageSubtreeUtil(TreeNode root){
        if(root == null){
            return new Pair1120(0, 0);
        }
        
        Pair1120 leftBranch = maximumAverageSubtreeUtil(root.left);
        Pair1120 rightBranch = maximumAverageSubtreeUtil(root.right);
        double sum = root.val + leftBranch.sum + rightBranch.sum;
        double count = 1 + leftBranch.count + rightBranch.count;
        gmax = Math.max(gmax, sum/count);
        return new Pair1120(sum, count);
    }
    
    public double maximumAverageSubtree(TreeNode root) {
        gmax = Double.MIN_VALUE;
        maximumAverageSubtreeUtil(root);
        return gmax;
        
        /*HashMap<TreeNode, Integer> sumMap = new HashMap<>();
        HashMap<TreeNode, Integer> nodeCount = new HashMap<>();
        
        findSum(root, sumMap);
        findNodes(root, nodeCount);
        
        for(Map.Entry<TreeNode, Integer> entry: sumMap.entrySet()){
            TreeNode nodeKey = entry.getKey();
            int sum = entry.getValue();
            int nc = nodeCount.get(nodeKey);
            double temp = nc + 0.0;
            gmax = Math.max(gmax, sum/temp);
        }
        return gmax;*/
    }
}