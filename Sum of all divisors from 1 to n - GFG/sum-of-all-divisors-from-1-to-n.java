//{ Driver Code Starts
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
			
            
            Solution ob = new Solution();
            long ans  = ob.sumOfDivisors(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static long sumOfDivisors(int n){
        // int sum = 0;
        // for (int i = 1; i <= n; ++i) {
        //     // Find all divisors of i
        //     // and add them
        //     for (int j = 1; j * j <= i; ++j) {
        //         if (i % j == 0) {
        //             if (i / j == j)
        //                 { sum += j; }
        //             else
        //                 { sum += j + i / j; }
        //         }
        //     }
        // }
        // return sum;
        
        
        long sum = 0;
        for (int i = 1; i <= n; ++i)
            sum += (n / i) * i;
        return sum;
    }
}