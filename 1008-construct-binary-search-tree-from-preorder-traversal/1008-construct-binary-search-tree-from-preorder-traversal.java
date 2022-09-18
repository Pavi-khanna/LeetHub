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
    public TreeNode bstFromPreorder(int[] preorder) {
        int len = preorder.length;
        int[] inorder = Arrays.copyOf(preorder, len);
        Arrays.sort(inorder);
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i=0; i< len; i++) {
            indexMap.put(inorder[i], i);
        }
        
        // System.out.println(Arrays.toString(inorder));
        
        TreeNode root = buildBT(preorder, 0, len-1, inorder, 0, len-1, indexMap);
        return root;
        
        
        // return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[]{0});
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
    
    public TreeNode bstFromPreorder(int[] preorder, int bound, int[] i) {
        if(i[0] == preorder.length || preorder[i[0]] > bound) return null;
        
        TreeNode root = new TreeNode(preorder[i[0]++]);
        root.left = bstFromPreorder(preorder, root.val, i);
        root.right = bstFromPreorder(preorder, bound, i);
        return root;
    }
}