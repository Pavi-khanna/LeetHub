// { Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java


class GFG
{
    ArrayList<Long> find(long arr[], int n, int x)
    {
        // code here
        int start = -1, end = -1;
        ArrayList<Long> list = new ArrayList<>();
        // for(int i=0; i<n; i++) {
        //     if(start==-1 && arr[i] == x) {start = i; end = i;}
        //     else if(arr[i] == x) end = i;
        // }
        
        start = first(arr, n, x, true);
        end = first(arr, n, x, false);
        
        list.add((long)start);
        list.add((long)end);
        return list;
    }
    
    int first(long[] arr, int n, int x, boolean isFirst) {
        int l=0, h=n-1, mid, first=-1;
        
        while(l<=h) {
            mid = l+(h-l)/2;
            
            if(arr[mid]==x) {
                first = mid;
                if(isFirst) h=mid-1;
                else l=mid+1;
            } else if(arr[mid]<x) l=mid+1;
              else h=mid-1;
        }
        return first;
    }
}



// { Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Long> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}
  // } Driver Code Ends