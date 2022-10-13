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
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] nums, int n, int target) {
        boolean isFirst = false;
        int first = -1, last = -1;
        for(int i=0; i<n; i++) {
            if(nums[i]==target) {
                if(!isFirst) { first = i; isFirst = true; }
                last = i;
            }
        }
        return first==-1 && last==-1 ? 0 : last-first+1;
        
        
        // int first = first(nums, target, true);
        // int last = first(nums, target, false);
        // return first==-1 && last==-1 ? 0 : last-first+1;
    }
    
    public int first(int[] nums, int target, boolean isFirst) {
        int start = 0, end = nums.length-1, first=-1;
        int mid = start + (end-start)/2;
        
        while(start <= end) {
            mid = start + (end-start)/2;
            
            if(nums[mid]==target) {
                first = mid;
                if(isFirst) end = mid-1;
                else start = mid+1;
            } else if(nums[mid]<target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return first;
    }
}