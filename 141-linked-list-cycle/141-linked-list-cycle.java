/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // put nodes in set and if while iterating we encounter the same node twice, return that
        // Set<ListNode> set = new HashSet<>();
        // while(head != null) {
        //     if(set.contains(head)) {
        //         return true;
        //     }
        //     set.add(head);
        //     head = head.next;
        // }
        // return false;
        
        
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                // System.out.println(slow.val);
                return true;
            }
        }
        return false;
    }
}