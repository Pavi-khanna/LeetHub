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
    
    public void recoverTree(TreeNode root) {
        // n, n
        List<Integer> list = new ArrayList<>();
        TreeNode node = root;
        inorder(node, list);
        
        int[] swapped = findTwoSwapped(list);
        recover(root, 2, swapped[0], swapped[1]);
    }
    
    public void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
    
  public int[] findTwoSwapped(List<Integer> nums) {
    int n = nums.size();
    int x = -1, y = -1;
    boolean swapped_first_occurrence = false;
    for(int i = 0; i < n - 1; ++i) {
      if (nums.get(i + 1) < nums.get(i)) {
        y = nums.get(i + 1);
        if (!swapped_first_occurrence) {
            // first swap occurrence
            x = nums.get(i);
            swapped_first_occurrence = true;
        } else {
            // second swap occurrence
            break;
        }
      }
    }
    return new int[]{x, y};
  }
    
    public void recover(TreeNode r, int count, int x, int y) {
    if (r != null) {
      if (r.val == x || r.val == y) {
        r.val = r.val == x ? y : x;
        if (--count == 0) return;
      }
      recover(r.left, count, x, y);
      recover(r.right, count, x, y);
    }
  }
}