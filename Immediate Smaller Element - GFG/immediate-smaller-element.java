//{ Driver Code Starts
//Initial Template for Java




import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().immediateSmaller(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    void immediateSmaller(int arr[], int n) {
        int[] res = new int[n];
        int p = 0;
        for(int i=0; i<arr.length-1; i++) {
            // for(int j=i+1; j<arr.length; j++) {
                if(arr[i+1] < arr[i]) {
                    res[p++] = arr[i+1];
                    // break;
                } else {
                    res[p++] = -1;
                }
            // }
        }
        res[n-1] = -1;
        for(int i=0; i<arr.length; i++) {
            arr[i] = res[i];
        }
        // return res;
    }
}