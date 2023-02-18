//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxGold(int n, int m, int a[][])
    {
        // int max = Integer.MIN_VALUE;
        // for(int i=0; i<n; i++) {
        //     max = Math.max(max, maxGold2(i, 0, a));
        // }
        // return max;
        
        
        int[][] t = new int[n+1][m+1];
        return maxGold2(n, m, a, t);
    }
    
    static int maxGold2(int n, int m, int a[][])
    {
        if(n<0 || n==a.length) return Integer.MIN_VALUE;
        if(m==a[0].length-1) return a[n][m];
        
        int up = maxGold2(n-1, m+1, a);
        int right = maxGold2(n, m+1, a);
        int down = maxGold2(n+1, m+1, a);
        
        return a[n][m] + Math.max(right, Math.max(up, down));
    }
    
    static int maxGold2(int n, int m, int a[][], int[][] t)
    {
        for(int j=m-1; j>=0; j--) {
            for(int i=0; i<n; i++) {
                if(i==0) t[i][j] = a[i][j] + Math.max(t[i][j+1], t[i+1][j+1]);
                else if(i==n-1) t[i][j] = a[i][j] + Math.max(t[i-1][j+1], t[i][j+1]);
                else t[i][j] = a[i][j] + Math.max(t[i-1][j+1], Math.max(t[i][j+1], t[i+1][j+1]));
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
            max = Math.max(max, t[i][0]);
        return max;
    }
}