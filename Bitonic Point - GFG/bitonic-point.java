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

            int ans = new Solution().findMaximum(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int findMaximum(int[] nums, int n) {
        int start =0, end = nums.length-1, mid=0, peak = 0, size = nums.length;
        if(nums.length==1) return 0;
        
        while(start < end) { // s and e both will come on the peak element in the end
            mid = start + (end-start)/2;
            
            if(nums[mid] < nums[mid+1]) { // left of mountain
                start = mid+1;
            } else {
                end = mid;
            }
            
            // if(mid > 0 && mid < nums.length - 1) {
            //     if(nums[mid] >= nums[mid - 1] && nums[mid] >= nums[mid + 1])
            //         return mid;
            //     else if (nums[mid] < nums[mid - 1])
            //         end = mid - 1;
            //     else
            //         start = mid + 1;
            // }else if(mid == 0) { // first ele
            //     if(nums[mid] >= nums[mid + 1]) return mid;
            //     else return mid + 1;
            // }else {              // last ele
            //     if(nums[mid] >= nums[mid - 1]) return mid;
            //     else return mid - 1;
            // } 
        }
        return nums[start];
    }
}