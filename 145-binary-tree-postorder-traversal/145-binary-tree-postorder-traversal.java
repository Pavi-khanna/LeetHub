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
    public List<Integer> postorderTraversal(TreeNode cur) {
        List<Integer> postOrder = new ArrayList<>();
        if (cur == null) return postOrder;
        // n, 2n
//         Stack<TreeNode> s1 = new Stack<>();
//         Stack<TreeNode> s2 = new Stack<>();
        
//         s1.push(cur);
//         while(!s1.isEmpty()) {
//             TreeNode root = s1.pop();
//             s2.add(root);
            
//             if(root.left!=null) s1.push(root.left);
//             if(root.right!=null) s1.push(root.right);
//         }
//         while(!s2.isEmpty()) {
//             postOrder.add(s2.pop().val);
//         }
        
        
        // 2n, n
        Stack<TreeNode> st = new Stack<>();
        while (cur != null || !st.isEmpty()) {
            if (cur != null) {
                st.push(cur);
                cur = cur.left;
            } else {
                TreeNode temp = st.peek().right;
                if (temp == null) {
                    temp = st.pop();
                    postOrder.add(temp.val);
                    while (!st.isEmpty() && temp == st.peek().right) {
                        temp = st.peek();
                        st.pop();
                        postOrder.add(temp.val);
                    }
                } else cur = temp;
            }
        }
        // postorder(cur,postOrder);
        return postOrder;
    }
    
    public void postorder(TreeNode root, List<Integer> res) {
        if(root==null) return;
        
        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
    }
}