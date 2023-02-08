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
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int len) {
        // sorting - nlogn, logn
        
        
        // n, n
        // int missing=0, repeat = 0;
        // int[] counter = new int[len];
        
        // for(int i=0; i<len; i++) {
        //     counter[arr[i]-1]++;
        // }
        
        // for(int i=0; i<len; i++) {
        //     if(counter[i] == 0) missing = i+1;
        //     if(counter[i] > 1) repeat = i+1;
        // }
        // return new int[] {repeat, missing};
        
        
        // n, 1
        // long n = arr.length;
        // long missing=0, repeat = 0;
        // long sum = n*(n+1)/2;
        // long squaredSum = (n*(n+1)*(2*n+1))/6;
        
        // for(int i=0; i<arr.length; i++) {
        //     sum -= (long)arr[i];
        //     squaredSum -= (long)arr[i]*(long)arr[i];
        // }
        // missing = (sum + squaredSum/sum)/2;
        // repeat = missing - sum;
        
        // return new int[] {(int)repeat, (int)missing};
        
        
        // n, 1
        int xor = arr[0], setBit, bucketX=0, bucketY=0;
        // xor with 1 to n and array = m^r
        for(int i=1; i < len; i++) {
            xor ^= arr[i];
        }
        for(int i=1; i <= len; i++) {
            xor ^= i;
        }
        
        setBit = xor & -xor;
        // put 1 to n and array elements into buckets accd to set bit
        for(int i=0; i<len; i++) {
            if((arr[i] & setBit) != 0) bucketX ^= arr[i];
            else bucketY ^= arr[i];
        }
        for(int i=1; i<=len; i++) {
            if((i & setBit) !=0) bucketX ^= i;
            else bucketY ^= i;
        }
        
        // check for missing and repeating element
        int missing = 0, repeat = 0;
        for(int i=0; i<len; i++) {
            if(arr[i] == bucketX) {
                repeat = bucketX;
                missing = bucketY;
                break;
            } else {
                missing = bucketX;
                repeat = bucketY;
            }
        }
        return new int[] {repeat, missing};
        
        
        //  int i=0;
        //  while(i < arr.length) {
        //      if(arr[i] != arr[arr[i]-1]) {
        //          swap(arr, i, arr[i]-1);
        //      } else i++;
        //  }
         
        //  int missing = 0, repeat = 0;
        //  for(int j=0; j<arr.length; j++) {
        //      if(arr[j] != j+1) {
        //          missing = j+1;
        //          repeat = arr[j];
        //      }
        //  }
        //  return new int[] {repeat, missing};
    }
    
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}