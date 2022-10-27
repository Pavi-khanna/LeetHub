class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;
        // if(needle.length() == 1) return haystack.indexOf(needle.charAt(0));
        
        int nlen = needle.length();
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