//{ Driver Code Starts
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
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            String ans = ob.is_palindrome(n);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String is_palindrome(int x)
    {
        // logn, 1
        if(x<0 || (x % 10 == 0 && x != 0)) return "No"; // eg 1 0
        
        int reversed=0;
        while(x>reversed) {
            reversed = reversed*10 + (x%10);
            x /= 10;
        }
        // System.out.println(reversed+" "+x);
        return (x == reversed || x == reversed/10) ? "Yes" : "No" ; // eg 12 1
    }
}