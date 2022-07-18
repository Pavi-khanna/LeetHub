class Solution {
    public String shortestCommonSupersequence(String s, String d) {
        int[][] t = new int[s.length()+1][d.length()+1];
        char[] b = longestCommonSubsequence(t, s.toCharArray(), d.toCharArray());
        
        StringBuilder sb=new StringBuilder(new String(b));
        sb.reverse();
        return sb.toString();
    }
    
    public char[] longestCommonSubsequence(int[][] t, char[] t1, char[] t2) {
        for(int i=0; i<t.length; i++) t[i][0] = 0;
        for(int i=0; i<t[0].length; i++) t[0][i] = 0;
                
        for(int i=1; i<t.length; i++) {
            for(int j=1; j<t[0].length; j++) {
                if(t1[i-1] == t2[j-1]) {
                    t[i][j] = 1+t[i-1][j-1];
                } else {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        
        int i=t.length-1, j=t[0].length-1, p=0;
        char[] str=new char[i+j-t[i][j]];
        while(i>0 && j>0) {
            if(t1[i-1] == t2[j-1]) {
                str[p++] = t1[i-1];
                i--; j--;
            } else {
                if(t[i-1][j]>t[i][j-1]) {
                    str[p++] = t1[i-1];
                    i--;
                }
                else {
                    str[p++] = t2[j-1];
                    j--;
                }
            }
        }
        while(i>0) str[p++] = t1[--i];
        while(j>0) str[p++] = t2[--j];
        return str;
    }
}