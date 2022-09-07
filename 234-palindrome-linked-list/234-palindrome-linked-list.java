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
    public boolean isPalindrome(ListNode head) {
        // n, n
//         List<Integer> vals = new ArrayList<>();

//         // Convert LinkedList into ArrayList.
//         ListNode currentNode = head;
//         while (currentNode != null) {
//             vals.add(currentNode.val);
//             currentNode = currentNode.next;
//         }

//         // Use two-pointer technique to check for palindrome.
//         int front = 0;
//         int back = vals.size() - 1;
//         while (front < back) {
//             // Note that we must use ! .equals instead of !=
//             // because we are comparing Integer, not int.
//             if (!vals.get(front).equals(vals.get(back))) {
//                 return false;
//             }
//             front++;
//             back--;
//         }
//         return true;
        
        
        // n, 1
        if(head==null || head.next==null) return true;
        ListNode slow = head, fast = head;
        
        // find middle
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        // reverse right half
        slow.next = reverseList(slow.next);
        
        // move slow forward
        slow = slow.next;
        
        // check if palindrome
        while(slow!=null){
           if(head.val != slow.val){return false;}
           head=head.next;
           slow=slow.next;
        }
        return true;
    }
    
    ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while(head!=null) {
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
}