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
    public int maxPathSum(TreeNode root) {
        int[] diameter = {Integer.MIN_VALUE};
        height(root,diameter);
        return diameter[0];
    }
    
    public int height(TreeNode node, int[] diameter) {
        if(node == null) return 0;
        
        int l = height(node.left, diameter);
        int r = height(node.right, diameter);
        
        int temp = Math.max(node.val+ Math.max(l,r), node.val);
        int ans = Math.max(temp, node.val+l+r);
        diameter[0] = Math.max(diameter[0], ans);
        
        return temp;
    }
}