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
        int[] maxVal = {Integer.MIN_VALUE};
        maxPathDown(root, maxVal);
        return maxVal[0];
    }
    
    public int maxPathDown(TreeNode root, int[] maxVal) {
        if(root==null) return 0;
        
        int lh = Math.max(0, maxPathDown(root.left, maxVal));
        int rh = Math.max(0, maxPathDown(root.right, maxVal));
        
        maxVal[0] = Math.max(maxVal[0], lh+rh+root.val);
        return Math.max(lh,rh)+root.val;
        
//         int lh = maxPathDown(root.left, maxVal);
//         int rh = maxPathDown(root.right, maxVal);
        
//         int maxIncludingCurrentNode = Math.max(root.val,root.val+Math.max(lh,rh));
//         int maxIncludingCurrentNodeAsRoot = Math.max(maxIncludingCurrentNode, root.val+lh+rh);
//         maxVal[0] = Math.max(maxIncludingCurrentNodeAsRoot, maxVal[0]);
        
        // return maxIncludingCurrentNode;
    }
}