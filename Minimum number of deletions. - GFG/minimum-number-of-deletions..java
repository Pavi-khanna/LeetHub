//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            String str = read.readLine().strip();
            Solution ob = new Solution();
            long ans = ob.minDeletions(str, n); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int minDeletions(String s, int n)
    {
        char[] t1 = s.toCharArray();
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        char[] t2 = sb.toString().toCharArray();          
        int[][] t = new int[s.length()+1][s.length()+1];
        
        return s.length() - longestCommonSubsequence(t, t1, t2);
    }
    
    public int longestCommonSubsequence(int[][] t, char[] t1, char[] t2) {
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