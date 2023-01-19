// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int i=0, j=0, max = -1;
        Map<Character, Integer> freq = new HashMap<>();
        
        while(j < s.length()) {
            char c = s.charAt(j);
            freq.put(c, freq.getOrDefault(c,0)+1);
            
            if(freq.size() == k) {
                max = Math.max(max, j-i+1);
            } else if(freq.size() > k) {
                while(freq.size() > k) {
                    char ch = s.charAt(i);
                    if(freq.containsKey(ch)) {
                        freq.put(ch, freq.get(ch)-1);
                        if(freq.get(ch) == 0) {
                            freq.remove(ch);
                        }
                    }
                    i++;
                }
            }
            j++;
        }
        return max;
    }
}