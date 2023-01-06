// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String[] S1 = s.split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            Solution ob = new Solution();
            int ans = ob.NthRoot(n, m);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public double multiply(double num, int n) {
        double ans = 1.0;
        for(int i = 1;i<=n;i++) {
            ans = ans*num;
        }
        return ans;
    }
    
    public int NthRoot(int n, int m) {
        // double low = 1;
        // double high = m;
        // double eps = 1e-6;
        
        // while((high - low) > eps) {
        //     double mid = (low + high) / 2.0; 
        //     if(multiply(mid, n) < m) {
        //         low = mid; 
        //     }
        //     else {
        //         high = mid; 
        //     }
        // }
        // System.out.println(low+ " "+high);
        // return (int)high;
        
        
        long low = 1L, high = m, mid, ans = -1;
        
		while(low <= high){
			mid = (low + high)/2;
			long power = mid;
			for(int i = 1; i < n; i++){
				power *= mid;
				if(power > m * 1L)break;
			}
			
			if(power == m * 1L){
				ans = mid;
				break;
			}
			else if(power > m)high = mid - 1;
			else low = mid + 1;
		}
// 		System.out.println(ans);
		return (int)(ans);
    }
}