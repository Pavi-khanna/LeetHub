// { Driver Code Starts
//Initial Template for Java


import java.util.*; 
import java.io.*; 

class GFG 
{ 
	public static void main (String[] args) { 
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            int array[] = new int[n];
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }

            Solution ob = new Solution();

            int ans[] = ob.help_classmate(array,n);

           	for (int i=0; i<n; i++) 
                System.out.print(ans[i]+" "); 
            System.out.println();
            t--;
        }
	} 
} 

// } Driver Code Ends


//User function Template for Java

class Solution {
	public static int[] help_classmate(int arr[], int n) 
	{ 
	       // n^2, 1
	    int[] res = new int[n];
        int p = 0;
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j] < arr[i]) {
                    res[p++] = arr[j];
                    break;
                } else if(j == n-1) {
                    res[p++] = -1;
                }
            }
        }
        res[n-1] = -1;
        return res;
    
    
        // n, n
        // int[] res = new int[n];
        // Stack<Integer> stack = new Stack<>();
        // int p = 0;
        
        // for(int i=n-1; i>=0; i--) {
        //     if(stack.isEmpty()) {
        //         res[p++] = -1;
        //     } else if(!stack.isEmpty() && stack.peek() < arr[i]) {
        //         res[p++] = stack.peek();
        //     } else if(!stack.isEmpty() && stack.peek() >= arr[i]) {
        //         while(stack.size()>0 && stack.peek() >= arr[i]) {
        //             stack.pop();
        //         }
        //         if(stack.isEmpty()) res[p++] = -1;
        //         else res[p++] = stack.peek();
        //     }
            
        //     stack.push(arr[i]);
        // }
        // // reverse
        // int i=0, j=n-1;
        // while(i<=j) {
        //     int temp = res[i];
        //     res[i++] = res[j];
        //     res[j--] = temp;
        // }
        // return res;
	} 
}
