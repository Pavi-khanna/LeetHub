/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;

        //https://leetcode.com/problems/rotate-list/discuss/1839864/Java-Thought-Process-Explained-from-Brute-Force-to-Optimized
        
        // find length
        ListNode cur = head;
        int len=1;
        while(cur.next!=null) {
            len++;
            cur = cur.next;
        }
        
        // go to that node - make it circular
        cur.next = head;
        k = len-k%len;
        while(k-- >0) cur = cur.next;
        
        // make node head and break connection
        head=cur.next;
        cur.next = null;
        
        return head;
    }
}