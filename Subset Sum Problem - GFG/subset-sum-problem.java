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
    public Boolean isSubsetSum(int n, int arr[], int sum){
        // return sum(arr, n, sum, 0, 0, new ArrayList<>(), new ArrayList<>());
        
        //  if(n==0) {
        //      if(sum!=0) return false;
        //      else return true;
        //  }
        //  if(arr[n-1] > sum) {
        //      return isSubsetSum(n-1, arr, sum);
        //  } else {
        //      return isSubsetSum(n-1, arr, sum-arr[n-1]) || isSubsetSum(n-1, arr, sum);
        //  }
        
        
        boolean[][] t = new boolean[n+1][sum+1];
        return sum(t, arr);
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