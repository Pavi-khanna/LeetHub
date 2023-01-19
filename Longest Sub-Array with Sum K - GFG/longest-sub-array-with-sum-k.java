//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int arr[], int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // int prefixSum = 0, max = 0;
        // for(int i=0; i<N; i++) {
        //     prefixSum += nums[i];
        //     map.put(prefixSum, map.getOrDefault(prefixSum, i-1)+1);
        //     max = Math.max(max, i-map.getOrDefault(prefixSum-K, Integer.MAX_VALUE));
        // }
        
        int sum = 0, maxLen = 0;
 
             for (int i = 0; i < n; i++) {
                sum += arr[i];
                
                if (sum == k) maxLen = i + 1;
                if (!map.containsKey(sum)) map.put(sum, i);
                if (map.containsKey(sum - k)) maxLen = Math.max(maxLen, i-map.get(sum - k));
             }
            
            
        // while(j<arr.length) {
        //     sum += arr[j];
            
        //     if(sum==k) {
        //         maxLen = Math.max(maxLen, j-i+1);
        //     } else if(sum > k) {
        //         // slide
        //         sum -= arr[i];
        //         i++;
        //     }
        //     j++;
        // }
        return maxLen;
    }
    
    
}


