/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // n, n
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        markParents(root, parents, target);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        visited.put(target, true);
        int current = 0;
        
        while(!queue.isEmpty()) {
            int level = queue.size();
            if(current++ == k) break;
            
            for(int i=0; i<level; i++) {
                TreeNode curr = queue.poll();
                
                if(curr.left!=null && visited.get(curr.left)==null) {
                    visited.put(curr.left, true);
                    queue.add(curr.left);
                }
                if(curr.right!=null && visited.get(curr.right)==null) {
                    visited.put(curr.right, true);
                    queue.add(curr.right);
                }
                if(parents.get(curr)!=null && visited.get(parents.get(curr))==null) {
                    visited.put(parents.get(curr), true);
                    queue.add(parents.get(curr));
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            list.add(queue.poll().val);
        }
        return list;
    }
    
    public void markParents(TreeNode root, Map<TreeNode, TreeNode> parents, TreeNode target) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            
            if(current.left!=null) {
                parents.put(current.left, current);
                queue.add(current.left);
            }
            if(current.right!=null) {
                parents.put(current.right, current);
                queue.add(current.right);
            }
        }
    }
}