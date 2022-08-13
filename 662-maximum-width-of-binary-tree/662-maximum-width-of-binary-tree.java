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
class Pair {
    TreeNode node;
    int index;
    Pair(TreeNode _node, int _index) {
        node = _node;
        index = _index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()) {
            int level = q.size(), first = 0, last = 0;
            int min = q.peek().index;
            for(int i=0; i<level; i++) {
                int id = q.peek().index - min;
                TreeNode node = q.poll().node;
                
                if(i==0) first = id;
                if(i==level-1) last = id;
                
                if(node.left!=null) q.add(new Pair(node.left, 2*id+1));
                if(node.right!=null) q.add(new Pair(node.right, 2*id+2));
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }
}