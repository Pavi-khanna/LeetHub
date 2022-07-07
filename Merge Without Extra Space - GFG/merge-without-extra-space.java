// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.io.*;

public class Main
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int m = Integer.parseInt(inputLine[1]);
		    long arr1[] = new long[n];
		    long arr2[] = new long[m];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr1[i] = Long.parseLong(inputLine[i]);
		    }
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<m; i++){
		        arr2[i] = Long.parseLong(inputLine[i]);
		    }
		    Solution ob = new Solution();
		    ob.merge(arr1, arr2, n, m);
		    
		    StringBuffer str = new StringBuffer();
		    for(int i=0; i<n; i++){
		        str.append(arr1[i]+" ");
		    }
		    for(int i=0; i<m; i++){
		        str.append(arr2[i]+" ");
		    }
		    System.out.println(str);
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) {
        // nlogn+n+n, n : n=n+m
        // long res[] = new long[n+m];
        // int i=0;
        // for(int j=0;j<n; j++) { res[i++] = arr1[j]; }
        // for(int j=0;j<m; j++) { res[i++] = arr2[j]; }
        // Arrays.sort(res);
        // i=0;
        // for(int j=0;j<n; j++) { arr1[j] = res[i++]; }
        // for(int j=0;j<m; j++) { arr2[j] = res[i++]; }
        
        
        // n*m, 1
        // int k;
        // for(int i=0;i<n;i++) {
        //     if(arr1[i]>arr2[0]) {
        //         long temp = arr1[i];
        //         arr1[i] = arr2[0];
        //         arr2[0] = temp;
        //     }
            
        //     long first = arr2[0];
        //     for(k=1;k<m && arr2[k]<first;k++) {
        //         arr2[k-1]=arr2[k];
        //     }
        //     arr2[k-1]=first;
        // }
        
        
        // no of gaps*logn, 1
        int gap = (int)Math.ceil((double)(n+m) / 2.0);
        while(gap>0) {
            // swap elements
            int i=0, j=gap;
            while(j<(n+m)) {
                if(j<n && arr1[i]>arr1[j]) swap(arr1, arr1, i, j);
                else if(j>=n && i<n && arr1[i]>arr2[j-n]) swap(arr1, arr2, i, j-n);
                else if(j>=n && i>=n && arr2[i-n]>arr2[j-n]) swap(arr2, arr2, i-n, j-n);
                
                j++;i++;
            }
            // re init gap
            if(gap == 1) {
                gap = 0;
            } else {
                gap =(int) Math.ceil((double)gap/2.0);
            }
        }
    }
    
    public static void swap(long[] a, long[] b, int i, int j) {
        long temp = a[i]; a[i] = b[j]; b[j] = temp; 
    }
}
