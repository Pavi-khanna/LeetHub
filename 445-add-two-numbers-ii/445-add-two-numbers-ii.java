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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // n1+n2, 1
//         l1 = reverseList(l1);
//         l2 = reverseList(l2);
//         return reverseList(addTwoNumbers1(l1,l2));
        
        
        if(l1 == null && l2 == null) return null;
        if(l1 == null || l2 == null) return l1 == null ? l2 : l1;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        ListNode curr = l1;
        while(curr != null){
            s1.add(curr.val);
            curr = curr.next;
        }
        
        curr = l2;
        while(curr != null){
            s2.add(curr.val);
            curr = curr.next;
        }
        
        ListNode head = null;
        int carry = 0;
        // build result list backwards
        while(!s1.isEmpty() || !s2.isEmpty() || carry==1){
            int x = !s1.isEmpty() ? s1.pop() : 0;
            int y = !s2.isEmpty() ? s2.pop() : 0;
            int sum = x + y + carry;
            curr = new ListNode(sum % 10);
            curr.next = head;
            head = curr;
            carry = sum / 10;
        }
        return head;
    }
    
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(0);
        ListNode curr = first;
        int carry = 0;
        
        while(l1!=null || l2!=null || carry==1) {
            int sum = 0;
            if(l1!=null) {
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null) {
                sum+=l2.val;
                l2=l2.next;
            }
            
            sum+=carry;
            carry=sum/10;
            ListNode node = new ListNode(sum%10);
            curr.next = node;
            curr = curr.next;
        }
        return first.next;
    }
    
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode temp = head;
        while(temp!=null) {
            ListNode next = temp.next;
            temp.next = newHead;
            newHead = temp;
            temp = next;
        }
        return newHead;
    }
}