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
class BSTIterator {
    List<Integer> sortedNodes;
    int index;
    // private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        sortedNodes = new ArrayList<>();
        index = -1;
        inorder(root);
        
        // pushAll(root);
    }
    
    public int next() {
        return sortedNodes.get(++index);
        
        // TreeNode current = stack.pop();
        // pushAll(current.right);
        // return current.val;
    }
    
    public boolean hasNext() {
        return index+1 < sortedNodes.size();
        
        // return !stack.isEmpty();
    }
    
    private void inorder(TreeNode root) {
        if(root==null) return;
        
        inorder(root.left);
        sortedNodes.add(root.val);
        inorder(root.right);
    }
    
    private void pushAll(TreeNode root) {
        // for(; root != null; stack.push(root), root = root.left);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */