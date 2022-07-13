// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public Boolean isSubsetSum(int N, int arr[], int sum){
        // return sum(arr, N, sum, 0, 0, new ArrayList<>(), new ArrayList<>());
        
        boolean[][] t = new boolean[N+1][sum+1];
        return sum(t, arr);
    }
    
    public boolean sum(int arr[], int n, int sum, int i, int s, List<Integer> ds, List<List<Integer>> ans) {
        if(i == n) {
           if(s == sum) {
               // System.out.println(ds);
               // ans.add(new ArrayList<>(ds));
               return true;
           }
           else return false;
        }
        
        ds.add(arr[i]);
        s+=arr[i];
        if(sum(arr,n,sum,i+1,s,ds,ans)) return true;
        ds.remove(ds.size()-1);
        s-=arr[i];
        
        if(sum(arr,n,sum,i+1,s,ds,ans)) return true;
        
        return false;
    }
    
    public boolean sum(boolean[][] t,int arr[]) {
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