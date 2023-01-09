// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here

        // int max = 0,row = -1;
        // for(int i=0;i<n; i++) {
        //     int curCount = 0;
        //     for(int j=0; j<m; j++) {
        //         if(arr[i][j] == 1) curCount++;
                
        //         if(max<curCount) {
        //             max = Math.max(max, curCount);
        //             row = i;
        //         }
        //     }
        // }
        // return row;
        
        // nlogm
        int max = 0,row = -1;
        for(int i=0;i<n; i++) {
            int index = search(arr[i], 0, m-1);
            //System.out.println(index);
            if(index != -1 && m-index>max) {
                max = m-index;
                row = i;
            }
        }
        return row;
        
        
        // int max = search(arr[0], 0, m-1),row = -1;
        // for(int i=1;i<n; i++) {
        //     //System.out.println(;
        //     if(max!= -1 && (m-max-1)>=0 && arr[i][m-max-1] == 1) {
        //         int index = search(arr[i], 0, m-max);
                
        //         if(index != -1 && m-index>max) {
        //         max = m-index;
        //         row = i;
        //     }
        //     } else {
        //         max = search(arr[i], 0, m-1);
        //     }
        // }
        // return row;
    }
    
    public static int search(int[] arr, int start, int end) {
        int low = start, high = end;
        while(low<=end) {
            int mid = (low+(high-low)/2);
            // first 1
            if((mid==0 || arr[mid-1]==0) && arr[mid] == 1) return mid;
            else if(arr[mid] == 0) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}