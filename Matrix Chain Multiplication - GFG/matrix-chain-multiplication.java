//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        // return matrixMultiplication(arr, 1, N-1);
        
        int[][] t = new int[N+1][N+1];
        for(int i=0; i<N; i++) Arrays.fill(t[i], -1);
        return matrixMultiplication(t, arr, 1, N-1);
    }
    
    static int matrixMultiplication(int arr[], int i, int j)
    {
        if(i>=j) return 0;
        
        int min = Integer.MAX_VALUE;
        
        for(int k=i; k<j; k++) {
            int temp = matrixMultiplication(arr, i, k)+
                       matrixMultiplication(arr, k+1,j)+
                       arr[i-1]*arr[k]*arr[j];
                       
            if(min>temp) min = temp;
        }
        return min;
    }
    
    static int matrixMultiplication(int[][] t, int arr[], int i, int j)
    {
        if(i>=j) return 0;
        
        if(t[i][j]!=-1) return t[i][j];
        
        int min = Integer.MAX_VALUE;
        
        for(int k=i; k<j; k++) {
            int temp = matrixMultiplication(t, arr, i, k)+
                       matrixMultiplication(t, arr, k+1,j)+
                       arr[i-1]*arr[k]*arr[j];
                       
            if(min>temp) min = temp;
        }
        return t[i][j] = min;
    }
}