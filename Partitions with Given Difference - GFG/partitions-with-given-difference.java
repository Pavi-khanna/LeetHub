//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int d=sc.nextInt();
            
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            Solution obj=new Solution();
            int res=obj.countPartitions(n, d, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

class Solution{

    public int countPartitions(int n, int d, int nums[]){
        int totalSum = 0;
        for(int num : nums) totalSum += num;
        int sum1 = (d+totalSum)/2;


        // return perfectSum2(nums, n, sum1);
        
        if(totalSum-d<0) return 0;
        if((totalSum-d)%2==1) return 0;
        
        // System.out.println(sum1);
            int[][] t = new int[n+1][totalSum+1];
	        for(int i=0; i<n+1; i++){
	            Arrays.fill(t[i], -1);
	        }
	        return perfectSum(t, nums, n, sum1);
        
        
        // int[][] t = new int[n+1][totalSum+1];
        // return sum(t, nums);
    }
    
    public int perfectSum2(int arr[],int n, int k) 
	{
	   if(n==0) {
            if(k==0) return 1;
            else return 0;
        }
        if(arr[n-1] > k) {
            return perfectSum2(arr,n-1,k);
        } else {
            return perfectSum2(arr,n-1, k-arr[n-1]) + perfectSum2(arr,n-1, k);
        }
	}
	
	public int perfectSum(int[][] t, int arr[],int n, int k) 
	{
	   int mod =(int) 1e9+7;
	   if(n==0) {
            if(k==0) return 1;
            else return 0;
        }
        
        if(t[n][k]!=-1) return t[n][k]%mod;
        
        if(arr[n-1] > k) {
             t[n][k] = perfectSum(t, arr,n-1,k);
            return t[n][k]%=mod;
        } else {
             t[n][k] = perfectSum(t, arr,n-1, k-arr[n-1]) + perfectSum(t, arr,n-1, k);
            return t[n][k]%=mod;
        }
	}
    
    public int sum(int[][] t,int arr[]) {
        int rows = t.length, cols = t[0].length, mod =(int) 1e9+7;
        for(int j=0; j<cols; j++) t[0][j] = 0;
        for(int i=0; i<rows; i++) t[i][0] = 1;
         
         for(int i=1; i<rows; i++) {
             for(int j=1; j<cols; j++) {
                 if(arr[i-1] > j) {
                    t[i][j] = t[i-1][j];
                 } else {
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                 }
                 t[i][j]%=mod;
             }
         }
         return t[rows-1][cols-1];
    }
}