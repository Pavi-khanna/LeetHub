// { Driver Code Starts
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
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long arr[], int n, int k)
    {
        // long[] res = new long[n-k+1];
        // boolean flag = false;
        // int p = 0;
        
        // for(int i=0; i<=n-k; i++) {
        //     long neg = 0;
        //     flag = false;
        //     for(int j=i; j<k+i; j++) {
        //         if(arr[j] < 0 && !flag) {
        //             neg = arr[j];
        //             flag = true;
        //         }
        //     }
        //     res[p++] = neg;
        // }
        // return res;
        
        
        
        int i = 0, j = 0, p = 0;
        long[] res = new long[n-k+1];
        Queue<Long> queue = new LinkedList<>();
        long neg = 0;
        
        if(n<k) return null;
        
        while(j < n) {
            if(arr[j]<0) queue.add(arr[j]);
            
            if(j-i+1 == k) {
                if(queue.size() > 0) {
                    res[p++] = queue.peek();
                    if(arr[i] == queue.peek()) queue.poll();
                } else {
                    res[p++] = 0;
                }
                i++;
            }
            j++;
        }
        return res;
    }
}