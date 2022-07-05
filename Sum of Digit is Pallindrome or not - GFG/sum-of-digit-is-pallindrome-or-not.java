// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.isDigitSumPalindrome(N));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    int isDigitSumPalindrome(int N) {
        // code here
        int num=0;
        while(N>0) {num += N%10; N/=10;}
        if(num < 0) return  0; 
        int reversed = 0, remainder, original = num;
        while(num >= 10) {
            remainder = num % 10;
            reversed = reversed * 10 + remainder;
            num  /= 10;
        }
        return original/10 == reversed && num == original%10 ? 1 : 0;
    }
}