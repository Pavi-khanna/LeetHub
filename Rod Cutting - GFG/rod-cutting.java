//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int val[], int n) {
        int[] wt = new int[n];
        for(int i=0; i<n; i++) wt[i] = i+1;
        int W = n;
        
        //  if(n==0 || W==0) return 0;
         
        //  if(wt[n-1] > W) {
        //      return knapSack(n-1, W, val, wt);
        //  } else {
        //      return Math.max(val[n-1] + knapSack(n, W-wt[n-1], val, wt),
        //                      knapSack(n-1, W, val, wt));
        //  }
        
        
        // int[][] t = new int[n+1][W+1];
        // for(int i=0; i<n+1; i++) {
        //     Arrays.fill(t[i], -1);
        // }
        // return knapSack(t, W, wt, val, n);
        
        
        int[][] t = new int[n+1][W+1];
        return knapSack(t, wt, val);
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
                    t[i][j] = Math.max(val[i-1] + t[i][j-wt[i-1]], t[i-1][j]);
                 }
             }
         }
         return t[rows-1][cols-1];
    }
}