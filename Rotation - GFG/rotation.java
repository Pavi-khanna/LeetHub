// { Driver Code Starts
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
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int findKRotation(int arr[], int n) {
        return findMin(arr);
    }
    
    public int findMin(int[] nums) {
        int start = 0, end = nums.length-1, mid = start + (end-start)/2;
        
        if(nums == null || nums.length == 0) return -1;
        
        while(start <= end) {
            mid = start + (end-start)/2;
            
            // we just have to go to the rotated side doesn't matter if its on the left or right bcz the min                element lies on that side only and accd to the graph of rotated sorted array the unsorted                    side is the rotated one.
            //                      /\    
            //                     /  \  /
            // array graph =           \/
            
            
            // left side
            if(nums[mid] < nums[end]) {
                end = mid;
            } else { // right side
                start = mid + 1;
            }
        }
        return mid;
    }
}