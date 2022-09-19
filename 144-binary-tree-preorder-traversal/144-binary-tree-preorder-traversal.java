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
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // n, n
        List<Integer> res = new ArrayList<Integer>();
        if(root==null) return res;
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        
        while(!st.isEmpty()) {
            root = st.pop();
            res.add(root.val);
            
            if(root.right!=null) st.push(root.right);
            if(root.left!=null) st.push(root.left);
        }
        // preorder(root,res);
        return res;
    }
    
    public void preorder(TreeNode root, List<Integer> res) {
        if(root==null) return;
        
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);
    }
}