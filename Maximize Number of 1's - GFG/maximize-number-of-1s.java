//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            int m = Integer.parseInt(br.readLine().trim());

            int ans = new Solve().findZeroes(arr, n, m);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    // m is maximum of number zeroes allowed to flip
    int findZeroes(int nums[], int n, int m) {
        // int max = 0;
        // for(int i=0; i<n; i++) {
        //     int zeroes = m;
        //     for(int j=i; j<n; j++) {
        //         if(nums[j]==0) {
        //             if(zeroes>0) zeroes--;
        //             else break;
        //         }
        //         max = Math.max(max, j-i+1);
        //     }
        // }
        // return max;
        
        
        
        int i = 0, j = 0;
        int numZeroes = 0, max = 0;
        
        if(nums.length<1) return -1;
        
        while(j < nums.length) {
            if(nums[j]==0) numZeroes++;
            
            if(numZeroes > m) {
                // move window fwd if m exhausted
                if(nums[i]==0) numZeroes--;
                i++;
            } else if(numZeroes <=m) {
                max = Math.max(max, j-i+1);
            }
            j++;
        }
        return max;
    }
}