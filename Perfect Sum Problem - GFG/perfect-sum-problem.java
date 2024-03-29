//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	   // return sum(arr, n, sum, 0, 0);
	    
	   // return sum(arr, n, sum, 0, 0, new ArrayList<>(), new ArrayList<>());
	   
	   
	   //return perfectSum2(arr,n, sum);
	   
	   
	   //int[][] t = new int[n+1][sum+1];
	   //for(int i=0; i<n+1; i++){
	   //    Arrays.fill(t[i], -1);
	   //}
	   //return perfectSum(t,arr,n, sum);
        
	    
	    int[][] t = new int[n+1][sum+1];
        return sum(t, arr);
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
             for(int j=0; j<cols; j++) {
                 if(arr[i-1] > j) {
                    t[i][j] = t[i-1][j];
                 } else {
                    t[i][j] = ((t[i-1][j-arr[i-1]]) + (t[i-1][j]));
                 }              // exclude             // include   dono call k ans jod diye
                 t[i][j] %= mod;
             }
         }
         return t[rows-1][cols-1];
    }
    
    public int sum(int arr[], int n, int sum, int i, int s) {
        if(s>sum)  return 0;
        if(i == n) {
           if(s == sum) {
               return 1;
           }
           else return 0;
        }
        
        s+=arr[i];
        int l = sum(arr,n,sum,i+1,s);
        s-=arr[i];
        int r = sum(arr,n,sum,i+1,s);
        
        return l+r;
    }
    
    public int sum(int arr[], int n, int sum, int i, int s, List<Integer> ds, List<List<Integer>> ans) {
        if(i == n) {
           if(s == sum) {
               // System.out.println(ds);
               ans.add(new ArrayList<>(ds));
           }
           return ans.size();
        }
        
        ds.add(arr[i]);
        s+=arr[i];
        sum(arr,n,sum,i+1,s,ds,ans);
        ds.remove(ds.size()-1);
        s-=arr[i];
        sum(arr,n,sum,i+1,s,ds,ans);
        
        return ans.size();
    }
}