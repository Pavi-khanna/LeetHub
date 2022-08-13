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
    public int countNodes(TreeNode root) {
        int[] count={0};
        return inorder(root, count);
    }
    
    public int inorder(TreeNode root, int[] count) {
        if(root!=null) {
            inorder(root.left,count);
            count[0]++;
            inorder(root.right,count);
        }
        return count[0];
    }
}