//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int nums[])
    {
        // code here
        int totalSum = 0;
        for(int num : nums) totalSum += num;
        boolean[][] t = new boolean[nums.length+1][(totalSum/2)+1];
        if(totalSum % 2 != 0) 
            return 0;
        else
            // return sum(nums, nums.length, totalSum / 2, 0, 0, new ArrayList<>(), new ArrayList<>());
            return sum(t, nums) ? 1 : 0;
    }
    
    static public boolean sum(boolean[][] t,int arr[]) {
        int rows = t.length, cols = t[0].length;
        for(int j=0; j<cols; j++) t[0][j] = false;
        for(int i=0; i<rows; i++) t[i][0] = true;
         
         for(int i=1; i<rows; i++) {
             for(int j=1; j<cols; j++) {
                 if(arr[i-1] > j) {
                    t[i][j] = t[i-1][j];
                 } else {
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                 }
             }
         }
         return t[rows-1][cols-1];
    }
}