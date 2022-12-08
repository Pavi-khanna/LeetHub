//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isPalindrome(String S) {
        return isPalindromeUtil(S, 0, S.length()-1);
    }
    
    int isPalindromeUtil(String str, int s, int e) {
        if(s>=e) return 1;
        
        if(str.charAt(s) != str.charAt(e)) return 0;
        return isPalindromeUtil(str, s+1, e-1);
    }
};