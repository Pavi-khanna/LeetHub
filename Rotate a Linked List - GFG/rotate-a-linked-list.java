// { Driver Code Starts
import java.util.*;
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
} 

class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            
            int a = sc.nextInt();
            Node head = new Node(a);
            Node tail = head;
            
            for (int i=0; i<n-1; i++)
            {
                a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }
            
            int k = sc.nextInt();
            
            Solution ob = new Solution();
            head = ob.rotate(head,k);
            printList(head);
        }
    }
    
    public static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
}
// } Driver Code Ends


/* node of linked list:

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

*/

class Solution{
    //Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        // add code here
        // if(head==null || head.next==null || k==0) return head;

        // //https://leetcode.com/problems/rotate-list/discuss/1839864/Java-Thought-Process-Explained-from-Brute-Force-to-Optimized
        
        // // find length
        // Node cur = head;
        // int len=1;
        // while(cur.next!=null) {
        //     len++;
        //     cur = cur.next;
        // }
        
        // // go to that node - make it circular
        // cur.next = head;
        // k = k%len;
        // while(k-- >0) cur = cur.next;
        
        // // make node head and break connection
        // head=cur.next;
        // cur.next = null;
        
        // return head;
        
        
        
        
        Node x = head; // creating copy of head in x to iterate the list while keeping the head unchanged
        if( x == null || k==0) return head; // if list is empty or if we don't have to rotate the list, return it
        int n = 1;  // counting no. of nodes in the list 
        while( x.next != null){
            x = x.next;
            n++;
        }
        k = n-k% n; // updating k acc. to point 5
        while(k-- > 0){
            Node y = head;
            int preValue = y.data;

            y = y.next; // starting from 2nd node
            while( y != null ){
                // swapping x.data with preValue
                int temp = y.data;  
                y.data = preValue;
                preValue = temp;

                y= y.next;
            }
            head.data = preValue; //updating 1st node value to last
        }
        return head;
    }
}
