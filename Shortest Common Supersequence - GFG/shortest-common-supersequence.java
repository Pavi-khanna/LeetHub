//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String s,String d,int m,int n)
    {
        int[][] t = new int[s.length()+1][d.length()+1];
        int lcs = longestCommonSubsequence(t, s.toCharArray(), d.toCharArray());
        
        return m+n-lcs;
    }
    
    public static int longestCommonSubsequence(int[][] t, char[] t1, char[] t2) {
        for(int i=0; i<t.length; i++) t[i][0] = 0;
        for(int i=0; i<t[0].length; i++) t[0][i] = 0;
                
        for(int i=1; i<t.length; i++) {
            for(int j=1; j<t[0].length; j++) {
                if(t1[i-1] == t2[j-1]) {
                    t[i][j] = 1+t[i-1][j-1];
                } else {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[t.length-1][t[0].length-1];
    }
}