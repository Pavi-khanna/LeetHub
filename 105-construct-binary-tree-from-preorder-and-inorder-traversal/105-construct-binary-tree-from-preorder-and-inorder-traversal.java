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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i=0; i< len; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildBT(preorder, 0, len-1, inorder, 0, len-1, indexMap);
    }
    
    public TreeNode buildBT(int[] preorder, int preStart, int preEnd,
                            int[] inorder, int inStart, int inEnd, Map<Integer, Integer> indexMap) {
        if(preStart>preEnd || inStart>inEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = indexMap.get(root.val);
        int numLeft = inRoot-inStart;
        
        root.left = buildBT(preorder, preStart+1, preStart+numLeft, inorder, inStart, inRoot-1, indexMap);
        root.right = buildBT(preorder, preStart+numLeft+1, preEnd, inorder, inRoot+1, inEnd, indexMap);
        return root;
    }
}