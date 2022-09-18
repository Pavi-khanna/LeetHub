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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode node = root;
        
        while(true) {
            if(node!=null) {
                st.push(node);
                node=node.left;
            } else {
                if(st.isEmpty()) break;
                
                node = st.pop();
                res.add(node.val);
                node=node.right;
            }
        }
        // inorder(root,res);
        return res;
    }
    
    public void inorder(TreeNode root, List<Integer> res) {
        if(root==null) return;
        
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
}