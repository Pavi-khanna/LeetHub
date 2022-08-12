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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null) return p==q;
        
        // return (p.val==q.val) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        
        Queue<TreeNode> queue = new LinkedList<>();
        if(p!=null && q!=null) {
            queue.add(p);
            queue.add(q);
        }
        while(!queue.isEmpty()) {
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            
            if(first==null && second==null) continue;
            if(first==null || second==null) return first==second;
            if(first.val!=second.val) return false;
                
            queue.add(first.left);
            queue.add(second.left);
            queue.add(first.right);
            queue.add(second.right);
        }
        return true;
    }
}