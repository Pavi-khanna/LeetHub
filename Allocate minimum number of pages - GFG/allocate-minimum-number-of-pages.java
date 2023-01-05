//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[] books,int n,int k)
    {
        int start = Integer.MIN_VALUE, end = 0;
        int res = -1;

        if(n < k) return -1;
        
        for(int i=0; i<n;i++) {
            end += books[i];
            start = Math.max(start, books[i]);
        }
        
        while(start <= end) {
            int mid = start +(end - start)/2;
            
            if(isValid(books, k, mid)) {
                res = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return res;
    }
    
    static boolean isValid(int[] books, int k, int maxPages) {
        int student = 1;
        int sum = 0;
        
        for(int i=0; i<books.length; i++) {
            sum += books[i];
            if(sum > maxPages) {
                student++;
                sum = books[i];
            }
            
            if(student > k) {
                return false;
            }
        }
        return true;
    }
};