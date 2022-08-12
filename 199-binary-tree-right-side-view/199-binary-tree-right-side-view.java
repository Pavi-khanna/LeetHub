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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ds = new ArrayList<>();
        right(ds, root, 0);
        return ds;
    }
    
    public void right(List<Integer> ds, TreeNode root, int level) {
        if(root==null) return;
        if(ds.size()==level) ds.add(root.val);
        
        right(ds, root.right, level+1);
        right(ds, root.left, level+1);
    }
}