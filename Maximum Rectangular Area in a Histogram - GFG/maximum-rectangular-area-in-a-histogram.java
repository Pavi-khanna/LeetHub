// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}



// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long heights[], long len) 
    {
        // your code here
        long max = Long.MIN_VALUE;
        int n = heights.length;
        long[] left = leftSmaller(heights), right = rightSmaller(heights), area = new long[n];
        for(int i=0; i<heights.length; i++) {
            // System.out.println(left[i] +" "+right[i]);
            area[i] = heights[i] * (right[i]-left[i]-1);
            max = Math.max(max, area[i]);
        }
        return max;
    }
    
    static long[] leftSmaller(long arr[]) {
        long[] res = new long[arr.length];
        Stack<Integer> stack = new Stack<>();
        int p = 0, pseudoIndex = -1, n = arr.length;

        for(int i=0; i<n; i++) {
            if(stack.isEmpty()) {
                res[p++] = pseudoIndex;
            } else if(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                res[p++] = stack.peek();
            } else if(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                while(stack.size()>0 && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) res[p++] = pseudoIndex;
                else res[p++] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }
    
    static long[] rightSmaller(long arr[]) {
        long[] res = new long[arr.length];
        Stack<Integer> stack = new Stack<>();
        int p = 0, pseudoIndex = arr.length, n = arr.length;
        
        for(int i=n-1; i>=0; i--) {
            if(stack.isEmpty()) {
                res[p++] = pseudoIndex;
            } else if(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                res[p++] = stack.peek();
            } else if(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                while(stack.size()>0 && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) res[p++] = pseudoIndex;
                else res[p++] = stack.peek();
            }
            stack.push(i);
        }
        // reverse
        int i=0, j=n-1;
        while(i<=j) {
            long temp = res[i];
            res[i++] = res[j];
            res[j--] = temp;
        }
        return res;
	} 
        
}



