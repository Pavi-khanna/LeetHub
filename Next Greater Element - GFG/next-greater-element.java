//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new Solution().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        // n^2, 1
        // long[] res = new long[n];
        // int p = 0;
        // for(int i=0; i<arr.length; i++) {
        //     for(int j=i+1; j<arr.length; j++) {
        //         if(arr[j] > arr[i]) {
        //             res[p++] = arr[j];
        //             break;
        //         } else if(j == n-1) {
        //             res[p++] = -1;
        //         }
        //     }
        // }
        // res[n-1] = -1;
        // return res;
        
        
        // n, n
        long[] res = new long[n];
        Stack<Long> stack = new Stack<>();
        int p = 0;
        
        for(int i=n-1; i>=0; i--) {
            if(stack.isEmpty()) {
                res[p++] = -1;
            } else if(!stack.isEmpty() && stack.peek() > arr[i]) {
                res[p++] = stack.peek();
            } else if(!stack.isEmpty() && stack.peek() <= arr[i]) {
                while(stack.size()>0 && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) res[p++] = -1;
                else res[p++] = stack.peek();
            }
            
            stack.push(arr[i]);
        }
        // reverse
        int i=0, j=n-1;
        while(i<=j) {
            long temp = res[i];
            res[i++] = res[j];
            res[j--] = temp;
        }
        return res;
        
        
        
    
    // nearest greater on left
        
    // int[] res = new int[n];
    // res[0] = -1;
    // int p = 1;
    // for (int i = 1; i < n; i++) {
    //   for(int j = i-1; j>=0; j--) {
    //       if(arr[j] > arr[i]) {
    //           res[p++] = arr[j];
    //           break;
    //       } else if(j==0){
    //           res[p++] = -1;
    //       }
    //   }
    // }
    // return res;
    
    
    // n, n
        // int[] res = new int[n];
        // Stack<Integer> stack = new Stack<>();
        // int p = 0;
        
        // for(int i=0; i<n; i++) {
        //     if(stack.isEmpty()) {
        //         res[p++] = -1;
        //     } else if(!stack.isEmpty() && stack.peek() > arr[i]) {
        //         res[p++] = stack.peek();
        //     } else if(!stack.isEmpty() && stack.peek() <= arr[i]) {
        //         while(stack.size()>0 && stack.peek() <= arr[i]) {
        //             stack.pop();
        //         }
        //         if(stack.isEmpty()) res[p++] = -1;
        //         else res[p++] = stack.peek();
        //     }
            
        //     stack.push(arr[i]);
        // }
        // return res;
    
    } 
}