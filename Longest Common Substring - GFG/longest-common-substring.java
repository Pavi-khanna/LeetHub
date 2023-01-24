//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int longestCommonSubstr(String text1, String text2, int n, int m){
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        
        // return longestCommonSubsequence(t1, t2, text1.length(), text2.length(), 0);
        
        int[][] t = new int[text1.length()+1][text2.length()+1];
        // for(int i=0; i<text1.length()+1; i++) {
        //     Arrays.fill(t[i],-1);
        // }
        // return longestCommonSubsequence(t, t1, t2, text1.length(), text2.length(),0);
        
        
        return longestCommonSubsequence(t, t1, t2);
    }
    
    public int longestCommonSubsequence(char[] t1, char[] t2, int n, int m, int count) {
        if(n==0 || m==0) return count;
        
        if(t1[n-1] == t2[m-1]) {
            return count = longestCommonSubsequence(t1, t2, n-1, m-1, count+1);
        } else {
            return count = Math.max(count, Math.max(longestCommonSubsequence(t1,t2,n-1,m, 0),
                           longestCommonSubsequence(t1,t2,n,m-1, 0)));
        }
    }
    
    public int longestCommonSubsequence(int[][] t, char[] t1, char[] t2, int n, int m, int count) {
        if(n==0 || m==0) return count;
        
        if(t[n][m] != -1) return t[n][m];
        
        if(t1[n-1] == t2[m-1]) {
            count = longestCommonSubsequence(t1, t2, n-1, m-1, count+1);
            return t[n][m] = 1+count;
        } else {
            count = Math.max(count, Math.max(longestCommonSubsequence(t1,t2,n-1,m, 0),
                           longestCommonSubsequence(t1,t2,n,m-1, 0)));
            return t[n][m] = count;
        }
    }
    
    public int longestCommonSubsequence(int[][] t, char[] t1, char[] t2) {
        for(int i=0; i<t.length; i++) t[i][0] = 0;
        for(int i=0; i<t[0].length; i++) t[0][i] = 0;
                
        // for(int i=1; i<t.length; i++) {
        //     for(int j=1; j<t[0].length; j++) {
        //         if(t1[i-1] == t2[j-1]) {
        //             t[i][j] = 1+t[i-1][j-1];
        //         } else {
        //             t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
        //         }
        //     }
        // }
        
    int count = 0;

	for (int i = 1; i < t.length; i++){
		for (int j = 1; j < t[0].length; j++){
			if (t1[i - 1] == t2[j - 1]) {
				t[i][j] = 1 + t[i - 1][j - 1];
			    count = Math.max(t[i][j], count);
			}
			else
				t[i][j] = 0;
		}
    }

	return count;
        // return t[t.length-1][t[0].length-1];
    }
}