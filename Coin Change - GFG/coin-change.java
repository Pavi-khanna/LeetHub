//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int amount) {
        // int ans = coinChange(coins.length, amount, coins);
        // return ans;
        
        
        int n = coins.length;
        long[][] t = new long[n+1][amount+1];
        // for(int i=0; i<n+1; i++) {
        //     Arrays.fill(t[i], -1);
        // }
        // int ans = coinChange(t, n, amount, coins);
        // return ans;
        
        
        long ans = coinChange(t, coins);
        return ans;
    }
    
    public int coinChange(int n, int W, int[] coins) {
        if(n==0) {
            if(W==0) return 1;
            else return 0;
        }
         
         if(coins[n-1] > W) {
             return coinChange(n-1, W, coins);
         } else {
             return coinChange(n, W-coins[n-1], coins) + coinChange(n-1, W, coins);
         }
    }
    
    public int coinChange(int[][] t, int n, int W, int[] coins) {
        if(n==0) {
             if(W==0) return 1;
             else return 0;
         }
        
        if(t[n][W] != -1) return t[n][W];
         
         if(coins[n-1] > W) {
             return t[n][W] = coinChange(t, n-1, W, coins);
         } else {
             return t[n][W] = coinChange(t, n, W-coins[n-1], coins)+
                             coinChange(t, n-1, W, coins);
         }
    }
    
    static long coinChange(long[][] t, int coins[]) {
         int rows = t.length, cols = t[0].length;
         for(int j=0; j<cols; j++) t[0][j] = 0;
         for(int i=0; i<rows; i++) t[i][0] = 1;
         
         for(int i=1; i<rows; i++) {
             for(int j=1; j<cols; j++) {
                 if(coins[i-1] > j) {
                    t[i][j] = t[i-1][j];
                 } else {
                    t[i][j] = t[i][j-coins[i-1]] + t[i-1][j];
                 }
             }
         }
         return t[rows-1][cols-1];
    }
}