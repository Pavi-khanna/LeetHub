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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // List<List<Integer>> levels = new ArrayList<List<Integer>>();
        // if (root == null) return levels;
        // helper(root, 0, levels);
        // return levels;
        
        
        // n, n
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList= new ArrayList<>();
        if(root == null) return wrapList;
        queue.add(root);
        
        while(!queue.isEmpty()) {
            // iterate on the size of the queue & add it to our list
            int level = queue.size();
            List<Integer> subList = new ArrayList<>();
            for(int i=0;i<level;i++) {
                TreeNode node = queue.poll();
                subList.add(node.val);
                
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
    
    public void helper(TreeNode node, int level, List<List<Integer>> levels) {
        if (levels.size() == level) levels.add(new ArrayList<Integer>());
        levels.get(level).add(node.val);
        // System.out.println(levels);

        if (node.left != null) helper(node.left, level + 1, levels);
        if (node.right != null) helper(node.right, level + 1, levels);
    }
}