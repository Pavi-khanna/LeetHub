// { Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node addOne(Node head) 
    { 
        // Node prev = head;
        
        // if(head.next == null) {
        //     head.data+=1;
        //     return head;
        // }
        
        // Node curr = head;
        // while(curr.next != null) {
        //     if(curr.data != 9) { prev = curr; }
        //     curr = curr.next;
        // }
        
        // if(curr.data == 9 && prev != null) {
        //     curr = prev;
        //     curr.data += 1;
        //     curr = curr.next;
        //     while(curr != null) {
        //         curr.data = 0;
        //         curr = curr.next;
        //     }
        // } else {
        //     curr.data += 1;
        // }
        // return head;
        
        
        
        
        
        // int carry = addWithCarry(head);
        
        // if (carry > 0) {
        //     Node newNode = new Node(carry);
        //     newNode.next = head;
        //     return newNode;
        // }
        // return head;
        
        
        
        
        // int carry = 1;
        // Node first = new Node(0);
        // head = reverse(head);
        // Node tail = first;
        
        // while(head != null || carry==1) {
        //     int sum = 0;
        //     if(head!=null) {
        //         sum+=head.data;
        //         head=head.next;
        //     }
        //     sum+=carry;
        //     carry=sum/10;
        //     Node node = new Node(sum%10);
        //     tail.next = node;
        //     tail = tail.next;
        // }
        // return reverse(first.next);
    }
    
    static int addWithCarry(Node head) {
        if (head == null)
            return 1;
 
        int res = head.data + addWithCarry(head.next);
 
        head.data = (res) % 10;
        // if(head!=null) {
        //     System.out.print(head.data+" ");
        //     if(head.next!=null) {
        //         System.out.print(head.next.data+" ");
        //     }
        // }
        // System.out.println();
        return (res) / 10;
    }
    
    public static Node reverse(Node head) {
        Node newHead = null;
        Node temp = head;
        while(temp!=null) {
            Node next = temp.next;
            temp.next = newHead;
            newHead = temp;
            temp = next;
        }
        return newHead;
    }
}
