// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static long maximumSumSubarray(int k, ArrayList<Integer> arr,int n){
        // code here
        // long max = Long.MIN_VALUE;
        
        // for(int i=0; i<=n-k; i++) {
        //     int sum = 0;
        //     for(int j=i; j<k+i; j++) {
        //         sum += arr.get(j);
        //     }
        //     max = Math.max(max, sum);
        // }
        // return max;
        
    
    
        
        int i = 0, j = 0;
        long sum = 0, max = Long.MIN_VALUE;
        
        if(n<k) return -1;
        
        while(j < n) {
            sum += arr.get(j);
            
            if(j-i+1 == k) {
                max = Math.max(max, sum);
                sum -= arr.get(i);
                i++;
            }
            j++;
        }
        return max;
    }
}