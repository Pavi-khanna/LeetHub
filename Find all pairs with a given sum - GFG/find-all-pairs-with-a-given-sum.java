//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long N = Long.parseLong(stt.nextToken());
            long M = Long.parseLong(stt.nextToken());
            long X = Long.parseLong(stt.nextToken());
            long A[] = new long[(int)(N)];
            long B[] = new long[(int)(M)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < N; i++) {
                A[i] = Long.parseLong(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < M; i++) {
                B[i] = Long.parseLong(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            pair [] answer = obj.allPairs(A, B, N, M, X);
            int sz = answer.length;
            
            if(sz==0)
            System.out.println(-1);
            else{
                StringBuilder output = new StringBuilder();
                for(int i=0;i<sz;i++){
                    if(i<sz-1)
                    output.append(answer[i].first +" "+ answer[i].second + ", ");
                    else
                    output.append(answer[i].first +" "+ answer[i].second);
                    
                }
                System.out.println(output);
            }
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

/*
class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
*/

class Solution {
    public pair[] allPairs( long a[], long b[], long n, long m, long k) {
        Map<Long, Integer> map = new HashMap<>();
        List<pair> result = new ArrayList<>();
        
        // for(int i=0; i<n; i++) {
        //     for(int j=0; j<m; j++) {
        //         if(a[i]+b[j] == k) {
        //             result.add(new pair(a[i], b[j]));
        //         }
        //     }
        // }
        
        for(int i=0; i<n; i++) map.put(a[i], map.getOrDefault(a[i], 0)+1);
        
        for(int i=0; i<m; i++) {
            if(map.containsKey(k-b[i])) result.add(new pair(k-b[i], b[i]));
        }
        
        pair[] pairs = new pair[result.size()];
        Collections.sort(result, (p,q)->(int)(p.first-q.first));
        for(int i=0; i<result.size(); i++) pairs[i] = result.get(i);
        return pairs;
    }
}