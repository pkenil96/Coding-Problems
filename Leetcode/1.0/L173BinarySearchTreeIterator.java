class L173BinarySearchTreeIterator {
    
    List<Integer> list;
    int currentPtr;
    
    public void inOrderTraversal(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
    }
    
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        inOrderTraversal(root, list);
        currentPtr = 0;
    }
    
    public int next() {
        return list.get(currentPtr++);
    }
    
    public boolean hasNext() {
        return currentPtr < list.size();
    }
}

