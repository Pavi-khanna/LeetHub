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
    boolean isLeaf(TreeNode node) {
        return node.left==null && node.right==null;
    }
    
    void addLeftTraversal(TreeNode node, List<Integer> ans) {
        TreeNode cur = node.left;
        while(cur!=null) {
            if(!isLeaf(cur)) ans.add(cur.val);
            if(cur.left!=null) cur=cur.left;
            else cur=cur.right;
        }
    }
    
    void addLeaves(TreeNode node, List<Integer> ans) {
        if(isLeaf(node)) {
            ans.add(node.val);
            return;
        }
        if(node.left!=null) addLeaves(node.left, ans);
        if(node.right!=null) addLeaves(node.right, ans);
    }
    
    void addRightTraversal(TreeNode node, List<Integer> ans) {
        TreeNode cur = node.right;
        Stack<Integer> tmp = new Stack<>();
        // List<Integer> tmp = new ArrayList<>();
        while(cur!=null) {
            if(!isLeaf(cur)) tmp.push(cur.val);
            if(cur.right!=null) cur=cur.right;
            else cur=cur.left;
        }
        // int i;
        // for(i=tmp.size()-1;i>=0;--i) {
        //     ans.add(tmp.get(i));
        // }
        while (!tmp.empty()) {
            ans.add(tmp.pop());
        }
    }
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(!isLeaf(root)) ans.add(root.val);
        
        addLeftTraversal(root, ans);
        addLeaves(root,ans);
        addRightTraversal(root,ans);
        return ans;
    }
}