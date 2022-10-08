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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 2n, 1
        int length = 0;
        ListNode curr = head;
        
        while(curr != null) {
            length++;
            curr = curr.next;
        }
        
        if(length==n) {
            return head.next;
        }
        
        int nodeBeforeIndex = length-n-1;
        curr = head;
        for(int i=0; i<nodeBeforeIndex; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
        
        
        // n, 1
//         ListNode first = new ListNode();
//         first.next = head;
//         ListNode slow = first, fast = first;
        
//         // move fast n distance
//         for(int i=0; i<n; i++) { fast = fast.next; }
        
//         // move fast & slow - (len-n) distance
//         // distances - fast = (len-n)+n, slow = len-n
//         while(fast.next != null) {  // on the last node
//             fast = fast.next;
//             slow = slow.next;
//         }
//         slow.next = slow.next.next;
//         return first.next;
    }
}