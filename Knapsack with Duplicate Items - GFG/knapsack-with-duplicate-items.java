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
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int n, int W, int val[], int wt[])
    {
        //  if(n==0 || W==0) return 0;
         
        //  if(wt[n-1] > W) {
        //      return knapSack(n-1, W, val, wt);
        //  } else {
        //      return Math.max(val[n-1] + knapSack(n, W-wt[n-1], val, wt),
        //                      knapSack(n-1, W, val, wt));
        //  }
        
        
        int[][] t = new int[n+1][W+1];
        for(int i=0; i<n+1; i++) {
            Arrays.fill(t[i], -1);
        }
        return knapSack(t, W, wt, val, n);
    }
    
    static int knapSack(int[][] t, int W, int wt[], int val[], int n) {
         if(n==0 || W==0) return 0;
         
         if(t[n][W] != -1) return t[n][W];
         
         if(wt[n-1] > W) {
             return t[n][W] = knapSack(t, W, wt, val, n-1);
         } else {
             return t[n][W] = Math.max(val[n-1] + knapSack(t, W-wt[n-1], wt, val, n),
                             knapSack(t, W, wt, val, n-1));
         }
    }
    
    static int knapSack(int[][] t, int wt[], int val[]) {
         int rows = t.length, cols = t[0].length;
         for(int j=0; j<cols; j++) t[0][j] = 0;
         for(int i=0; i<rows; i++) t[i][0] = 0;
         
         for(int i=1; i<rows; i++) {
             for(int j=1; j<cols; j++) {
                 if(wt[i-1] > j) {
                    t[i][j] = t[i-1][j];
                 } else {
                    t[i][j] = Math.max(val[i-1] + t[i-1][j-wt[i-1]], t[i-1][j]);
                 }
             }
         }
         return t[rows-1][cols-1];
    }
}