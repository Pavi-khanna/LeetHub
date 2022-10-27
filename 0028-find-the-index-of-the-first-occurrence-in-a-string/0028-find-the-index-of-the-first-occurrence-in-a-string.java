class Solution {
    public int strStr(String haystack, String needle) {
        int nlen = needle.length();
        
        if(nlen > haystack.length()) return -1;
        if(nlen == 0) return 0;
        // if(needle.length() == 1) return haystack.indexOf(needle.charAt(0));
        
        for(int i=0; i<haystack.length(); i++) {
            if(needle.charAt(0) == haystack.charAt(i)) {
                if(i+nlen <= haystack.length() && needle.equals(haystack.substring(i, i+nlen))) {
                    return i;
                }
            }
        }
        return -1;
    }
}