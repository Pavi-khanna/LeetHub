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
        // int[] count={0};
        // return inorder(root, count);
        
        
        if(root==null) return 0;
        
        int lh=getHeightLeft(root);
        int rh=getHeightRight(root);
        
        if(lh == rh) return ((2<<lh)-1);
        else return countNodes(root.left)+countNodes(root.right)+1;
    }
    
    public int getHeightLeft(TreeNode root){
        int count=0;
        while(root.left!=null){
            count++;
            root = root.left;
        }
        return count;
    }
    
    public int getHeightRight(TreeNode root){
        int count=0;
        while(root.right!=null){
            count++;
            root = root.right;
        }
        return count;
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