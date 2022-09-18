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
class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    boolean reverse = true;

    public BSTIterator(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }
    
    public int next() {
        TreeNode current = stack.pop();
        if(reverse) pushAll(current.left);
        else pushAll(current.right);
        return current.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void pushAll(TreeNode root) {
        while(root != null) {
            stack.push(root);
            if(reverse) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return twoSum(list, k);
        
        
//         if(root == null) return false;
//         BSTIterator l = new BSTIterator(root, false);
//         BSTIterator r = new BSTIterator(root, true);
        
//         int i = l.next();
//         int j = r.next();
//         while(i<j) {
//             if(i+j == k) return true;
//             else if(i+j < k) i = l.next();
//             else j = r.next();
//         }
//         return false;
    }
    
    public void inorder(TreeNode root, List<Integer> res) {
        if(root==null) return;
        
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
    
    public boolean twoSum(List<Integer> nums, int target) {
        // n, n
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.size(); i++) {
            int secondNum = target-nums.get(i);
            if(map.containsKey(secondNum)) {
                return true;   // in order
            }
            map.put(nums.get(i), i);
        }
        return false;
    }
}