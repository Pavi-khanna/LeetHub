public class ListNode {
    int val;
    ListNode next;
    
    ListNode() {}
    
    ListNode(int x) {
        this.val = x;
    }
}
class MyLinkedList {
    int size = 0;
    ListNode head;

    public MyLinkedList() {
        this.size = 0;
        this.head = new ListNode();
    }
    
    public int get(int index) {
        if(index<0 || index>=size) return -1;
        
        ListNode curr = head;
        for(int i=0; i<=index; i++) curr = curr.next;
        return curr.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index < 0) index = 0;
        size++;
        
        ListNode prev = head;
        for(int i=0; i<index; i++) prev = prev.next;
        
        ListNode node = new ListNode(val);
        node.next = prev.next;
        prev.next = node;
    }
    
    public void deleteAtIndex(int index) {
        if(index<0 || index>=size) return;
        
        size--;
        ListNode prev = head;
        for(int i=0; i<index; i++) prev = prev.next;
        
        prev.next = prev.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */