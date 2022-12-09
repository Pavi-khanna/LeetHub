//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size)
    {
        int c = 0, ca = 0;
        for(int num : a) {
            if(c==0) ca = num;
            c += (ca == num) ? 1 : -1;
        }

        int maj = 0;
        for(int num : a) {
            if(num == ca) maj++;
        }
        return maj<=size/2 ? -1 : ca;
    }
}