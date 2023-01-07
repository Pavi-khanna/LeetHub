//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            int mat[][] = new int[n][m];
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < m; j++)
                  mat[i][j] = sc.nextInt();
            }
            
            int x = sc.nextInt();
            
            System.out.println (new Sol().matSearch(mat, n, m, x));
        }
        
    }
}
// } Driver Code Ends


class Sol
{
    public static int matSearch(int matrix[][], int N, int M, int t)
    {
        // mn, 1
        // for(int i=0; i<matrix.length; i++) {
        //     for(int j=0; j<matrix[0].length; j++) {
        //         if(t == matrix[i][j]) return 1;
        //     }
        // }
        // return 0;
        
        
        // n+m, 1
        int n = matrix.length, m = matrix[0].length; 
        int i=0, j=m-1;
        while(i<n && j>=0) {
            if(matrix[i][j]==t) return 1;
            
            if(matrix[i][j]>t) j--;
            else i++;
        }
        return 0;
    }
}