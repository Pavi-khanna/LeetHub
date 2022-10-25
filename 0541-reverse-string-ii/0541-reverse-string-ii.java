class Solution {
    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        for(int i=0; i<s.length(); i+=2*k) {
             reverse(str, i, k);
        }
        return new String(str);
    }
    
    public void reverse(char[] s, int start, int k) {
        int low = start, high = Math.min(start+k-1, s.length-1);
        
        while(low<high) {
            char t = s[low];
            s[low++] = s[high];
            s[high--] = t;
        }
    }
}