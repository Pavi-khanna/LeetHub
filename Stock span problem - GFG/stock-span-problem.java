// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}// } Driver Code Ends



class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int arr[], int n) {
    // n^2,1
    // int[] res = new int[n];
    // res[0] = 1;
    // for (int i = 1; i < n; i++) {
    //   res[i]=1;
    //   for(int j = i-1; j>=0 && (arr[j] <= arr[i]); j--) {
    //     res[i]++;
    //   }
    // }
    // return res;
    
        // n, n
        int[] res = new int[n];
        // could also save the pair<a[i], i> but y would we want to make it complex
        Stack<Integer> stack = new Stack<>();
        int p = 0;

        for(int i=0; i<n; i++) {
            if(stack.isEmpty()) {
                res[p++] = 1+i;  // 1 more than i means it has reached beyond 0
            } else if(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                res[p++] = i-stack.peek();    // 
            } else if(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                while(stack.size()>0 && arr[stack.peek()] <= arr[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) res[p++] = 1+i;
                else res[p++] = i-stack.peek();
            }
            stack.push(i);
        }
        return res;
    }
}