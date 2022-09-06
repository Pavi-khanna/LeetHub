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
    public ListNode mergeKLists(ListNode[] lists) {
        // nlogn, n
//         List<Integer> list = new ArrayList<>();
//         for(ListNode l : lists) {
//             while(l!=null) {
//                 list.add(l.val);
//                 l = l.next;
//             }
//         }
//         Collections.sort(list);
        
//         // System.out.println(list.toString());
//         ListNode head = new ListNode(), tail = head;
        
//         for(int i=0; i<list.size(); i++) {
//             tail.next = new ListNode(list.get(i));
//             tail = tail.next;
//         }
//         tail.next = null;
//         return head.next;
        
        
        // k*n, 1
        // if (lists == null || lists.length == 0) {
        //     return null;
        // }
        // for (int i = 1; i < lists.length; ++i) {
        //     lists[0] = mergeTwoLists(lists[0], lists[i]);
        // }
        // return lists[0];
        
        
        // n*logk, n
        Queue<ListNode> minHeap = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val-l2.val;
            }
        });
        for(ListNode l : lists) {
            if(l!=null) {
                minHeap.add(l);
            }
        }
        ListNode head = new ListNode(), tail = head;
        while(!minHeap.isEmpty()) {
            tail.next = minHeap.poll();
            tail = tail.next;
            ListNode next = tail.next;
            if(next!=null) minHeap.add(next);
        }
        return head.next;
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        
        ListNode tail = prehead;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        
        tail.next = l1 == null ? l2 : l1;
        return prehead.next;
    }
}