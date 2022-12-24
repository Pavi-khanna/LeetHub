//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n+5];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n-1; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.missingNumber(a, n));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public static int missingNumber(int a[], int N)
    {
        // n, 1
        // int sum = N*(N+1)/2;
        // for(int i=0; i<a.length; i++) {
        //     sum -= a[i];
        // }
        // return sum;
        
        
        // n, 1
        // int sum = 1;
        // for(int i=2; i<=N; i++) {
        //     sum += i;
        //     sum -= a[i-2];
        // }
        // return sum;
        
        
        // n, 1
        int xor1 = 0, xor2 = 0;
        for(int i=1; i<=N; i++) {
            xor1 ^= i;
            xor2 ^= a[i-1];
        }
        return xor1^xor2;
        
        
        // Arrays.sort(nums);
        // if (nums[nums.length-1] != nums.length) {
        //     return nums.length;
        // } else if (nums[0] != 1) {
        //     return 1;
        // }
        
        // for(int i=1;i<nums.length;i++) {
        //     if(nums[i] != nums[i-1]+1) {
        //         return nums[i-1]+1;
        //     }
        // }
        // return -1;
    }
}