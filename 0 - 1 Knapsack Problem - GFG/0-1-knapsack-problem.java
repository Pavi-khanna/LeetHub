// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}



// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        //  if(n==0 || W==0) return 0;
         
        //  if(wt[n-1] > W) {
        //      return knapSack(W, wt, val, n-1);
        //  } else {
        //      return Math.max(val[n-1] + knapSack(W-wt[n-1], wt, val, n-1),
        //                      knapSack(W, wt, val, n-1));
        //  }
        
        
        int[][] t = new int[n+1][W+1];
        return knapSack(t, wt, val);
    } 
    
    static int knapSack(int[][] t, int wt[], int val[]) {
         int rows = t.length, cols = t[0].length;
        //  for(int j=0; j<cols; j++) t[0][j] = 0;
        //  for(int i=0; i<rows; i++) t[i][0] = 0;
         
         for(int i=0; i<rows; i++) {
             for(int j=0; j<cols; j++) {
                 if(i==0 || j==0) t[i][j] = 0;
                 else if(wt[i-1] > j) {
                    t[i][j] = t[i-1][j];
                 } else {
                    t[i][j] = Math.max(val[i-1] + t[i-1][j-wt[i-1]], t[i-1][j]);
                 }
             }
         }
         return t[rows-1][cols-1];
    }
}


