//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    Solution ob = new Solution();
		    out.println(ob.kthSmallest(arr, 0, n-1, k));
		}
		out.flush();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int kthSmallest(int[] nums, int l, int r, int k) 
    { 
        PriorityQueue<Integer> heap =
            new PriorityQueue<Integer>(Collections.reverseOrder());

        // keep k largest elements in the heap
        for (int n: nums) {
          heap.add(n);
          // System.out.println(heap.peek());
          if (heap.size() > (k))
            {heap.poll();
            }
            
         
        }

        // output
        return heap.poll();
    } 
}
