// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a1[] = in.readLine().trim().split("\\s+");
            int a[] = new int[n];
            for(int i = 0;i < n;i++)
                a[i] = Integer.parseInt(a1[i]);
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.leftSmaller(n, a);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution{
    static List<Integer> leftSmaller(int n, int arr[])
    {
        //code here
    // List<Integer> res = new ArrayList<>();
    // res.add(-1);
    // for (int i = 1; i < n; i++) {
    //   for(int j = i-1; j>=0; j--) {
    //       if(arr[j] < arr[i]) {
    //           res.add(arr[j]);
    //           break;
    //       } else if(j==0){
    //           res.add(-1);
    //       }
    //   }
    // }
    // return res;
    
    
    // n, n
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++) {
            if(stack.isEmpty()) {
                res.add(-1);
            } else if(!stack.isEmpty() && stack.peek() < arr[i]) {
                res.add(stack.peek());
            } else if(!stack.isEmpty() && stack.peek() >= arr[i]) {
                while(stack.size()>0 && stack.peek() >= arr[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) res.add(-1);
                else res.add(stack.peek());
            }
            stack.push(arr[i]);
        }
        return res;
    
    }
}