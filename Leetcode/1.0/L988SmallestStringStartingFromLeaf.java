/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class L988SmallestStringStartingFromLeaf {
    
    
    static String smallest;
    //static ArrayList<String> list;
    
    public static void dfs(TreeNode root, StringBuilder temp){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            temp.insert(0, (char)('a'+root.val));
            String S = temp.toString();
            if(smallest.equals("~")){
                smallest = S;
            } else if (S.compareTo(smallest) < 0){
                smallest = S;
            }
            //list.add(temp.toString());
            temp.deleteCharAt(0);
            return;
        }
        temp.insert(0, (char)('a'+root.val));
        dfs(root.left,temp);
        dfs(root.right,temp);   
        temp.deleteCharAt(0);
    }
    
    public String smallestFromLeaf(TreeNode root) {
        //list = new ArrayList<>();
        smallest = "~";
        dfs(root, new StringBuilder());
        //System.out.println(list.toString());
        return smallest;
    }
}