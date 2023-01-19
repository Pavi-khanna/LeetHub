// { Driver Code Starts
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
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        
        // int N = txt.length();
        // int n = pat.length();
 
        // // Initialize result
        // int res = 0;
 
        // for (int i = 0; i <= N - n; i++) {
 
        //     String s = txt.substring(i, i + n);
 
        //     // Check if the word and substring are
        //     // anagram of each other.
        //     if (araAnagram(pat, s))
        //         res++;
        // }
        // return res;
        
        
        Map<Character, Integer> freq = new HashMap<>();
        // populate map
        for(int i=0; i<pat.length(); i++) {
            char s = pat.charAt(i);
            freq.put(s, freq.getOrDefault(s,0)+1);
        }
        
        int i=0,j=0,size = freq.size(), count = size, ans = 0;
        
        while(j<txt.length()) {
            // calculations
            char ele = txt.charAt(j);
            if(freq.containsKey(ele)) {
                freq.put(ele, freq.get(ele)-1);
                if(freq.get(ele) == 0) count--;
            }
            
            if(j-i+1 == pat.length()) {
                // keep count to reduce traversing again and again
                // yahan ja k dkhna k count bhi rkhna pdega
                if(count == 0) ans++;
                // reverse work for excluding ith elem ans
                if(freq.containsKey(txt.charAt(i))) {
                    freq.put(txt.charAt(i), freq.getOrDefault(txt.charAt(i), 0)+1);
                    if(freq.get(txt.charAt(i)) == 1) count++;
                }
                i++;
            }
            j++;
        }
        return ans;
    }
    
    static boolean araAnagram(String s1, String s2) {
        // converting strings to char arrays
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
 
        // sorting both char arrays
        Arrays.sort(ch1);
        Arrays.sort(ch2);
 
        // Check for equality of strings
        if (Arrays.equals(ch1, ch2))
            return true;
        else
            return false;
    }
}