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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapper = new ArrayList<>();
        
        if(root==null) return wrapper;
        
        //add root
        queue.add(root);
        boolean flag=true;
        
        // till queue is empty add elements to a new list according to the flag
        while(!queue.isEmpty()) {
            int level = queue.size();
            LinkedList<Integer> subList = new LinkedList<>();
            // List<Integer> subList = new ArrayList<Integer>(level);
            for(int i=0;i<level;i++) {
                int index=i;
                
                if(queue.peek().left !=null) queue.add(queue.peek().left);
                if(queue.peek().right !=null) queue.add(queue.peek().right);
                // add to subList
                if(flag==true) subList.add(queue.poll().val);
                else subList.addFirst(queue.poll().val);
                
                // if(flag==true) subList.add(queue.poll().val);
                // else subList.add(0, queue.poll().val);
            }
            // reset flag and add to wrapper
            flag=!flag;
            wrapper.add(subList);
        }
        return wrapper;
    }
}