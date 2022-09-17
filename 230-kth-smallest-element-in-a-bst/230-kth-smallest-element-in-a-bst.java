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
    public int kthSmallest(TreeNode root, int k) {
        // any traversal + sort - nlogn+n, n
        
        // n, n
        // ArrayList<Integer> inorder = new ArrayList<>();
        // inorder(root, inorder);
        // return inorder.get(k-1);
        
        
        // int[] pos = new int[1];
        // return inorder(root, k, pos).val;
        
        
        // h, h
        LinkedList<TreeNode> stack = new LinkedList<>();

        int count=0;
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (++count == k) return root.val;
            root = root.right;
        }
    }
    
    // public void inorder(TreeNode root, List<Integer> res) {
    //     if(root!=null) {
    //         inorder(root.left,res);
    //         res.add(root.val);
    //         inorder(root.right,res);
    //     }
    // }
    
    public TreeNode inorder(TreeNode root, int k, int[] pos) {
        if(root!=null) {
            TreeNode left = inorder(root.left,k,pos);
            // if(left!=null) return left;
            pos[0]+=1;
            if(pos[0]==k) return root;
            inorder(root.right,k,pos);
        }
        return root;
    }
}