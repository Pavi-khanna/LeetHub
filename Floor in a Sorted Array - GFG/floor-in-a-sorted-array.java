// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Searching
{
    public static void main (String[] args)throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
           String a[] = read.readLine().trim().split("\\s+");
           int n = Integer.parseInt(a[0]);
           long x = Long.parseLong(a[(int)1]);
           String st[] = read.readLine().trim().split("\\s+");
        
           long arr[] = new long[n];
           for(int i = 0; i < n; i++)
           {
               arr[i] = Long.parseLong(st[i]);
           }
           
           System.out.println(new Solution().findFloor(arr, n, x));
          
        }
    }
    
}// } Driver Code Ends


class Solution{
    
    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long arr[], int n, long x)
    {
        // logn, 1
        int res = -1;
        int start =0, end = arr.length-1;
    
        while(start <= end) {
            int mid = start + (end-start)/2;
            
            if(arr[mid]<x) {
                res = mid;   // right m jaane se pehle chota no saved
                start = mid+1;
            } else if(arr[mid]>x) {
                end = mid-1;
            } else {
                return mid;
            }
        }
        return res;
        
        
        // ceil
        // int res = -1;
        // int start =0, end = arr.length-1;
    
        // while(start <= end) {
        //     int mid = start + (end-start)/2;
            
        //     if(arr[mid]<x) {
        //         start = mid+1;
        //     } else if(arr[mid]>x) {
        //         res = mid;  // left m jaane se pehle bda no saved
        //         end = mid-1;
        //     } else {
        //         return mid;
        //     }
        // }
        // return res;
    }
    
}