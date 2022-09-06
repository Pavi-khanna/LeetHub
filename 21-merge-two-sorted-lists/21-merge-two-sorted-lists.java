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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//         ListNode prehead = new ListNode(-1);
        
//         ListNode tail = prehead;
//         while(l1 != null && l2 != null) {
//             if(l1.val <= l2.val) {
//                 tail.next = l1;
//                 l1 = l1.next;
//             } else {
//                 tail.next = l2;
//                 l2 = l2.next;
//             }
//             tail = tail.next;
//         }
        
//         tail.next = l1 == null ? l2 : l1;
//         return prehead.next;
        
        ListNode h = new ListNode(0);
    ListNode ans=h;
    while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
            h.next = l1;
            h = h.next;
            l1 = l1.next;
        } else {
            h.next = l2;
            h = h.next;
            l2 = l2.next;
        }
    }
    if(l1==null){
        h.next=l2;
    }
    if(l2==null){
        h.next=l1;
    } 
    return ans.next;
    }
}