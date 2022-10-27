class Solution {
    public int strStr(String haystack, String needle) {
//         int nlen = needle.length();
        
//         if(nlen > haystack.length()) return -1;
//         if(nlen == 0) return 0;
//         // if(needle.length() == 1) return haystack.indexOf(needle.charAt(0));
        
//         for(int i=0; i<haystack.length(); i++) {
//             if(needle.charAt(0) == haystack.charAt(i)) {
//                 if(i+nlen <= haystack.length() && needle.equals(haystack.substring(i, i+nlen))) {
//                     return i;
//                 }
//             }
//         }
//         return -1;
        
        
        int m = haystack.length(),n = needle.length();
    if(m < n) return -1;
    else if(n == 0) return 0;
    
    int i = 0;
    while(i <= m-n) {
        int j = 0;
        while (j < n) {
            if(haystack.charAt(i + j) != needle.charAt(j)) break;
            
            j++;
        }
        if(j == n)
            return i;
        i++;
    }
    
    return -1;
    }
}