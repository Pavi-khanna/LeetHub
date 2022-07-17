class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        
        // return longestCommonSubsequence(t1, t2, text1.length(), text2.length());
        
        int[][] t = new int[text1.length()+1][text2.length()+1];
        for(int i=0; i<text1.length()+1; i++) {
            Arrays.fill(t[i],-1);
        }
        return longestCommonSubsequence(t, t1, t2, text1.length(), text2.length());
    }
    
    public int longestCommonSubsequence(char[] t1, char[] t2, int n, int m) {
        if(n==0 || m==0) return 0;
        
        if(t1[n-1] == t2[m-1]) {
            return 1+longestCommonSubsequence(t1, t2, n-1, m-1);
        } else {
            return Math.max(longestCommonSubsequence(t1,t2,n-1,m),
                           longestCommonSubsequence(t1,t2,n,m-1));
        }
    }
    
    public int longestCommonSubsequence(int[][] t, char[] t1, char[] t2, int n, int m) {
        if(n==0 || m==0) return 0;
        
        if(t[n][m] != -1) return t[n][m];
        
        if(t1[n-1] == t2[m-1]) {
            return t[n][m] = 1+longestCommonSubsequence(t, t1, t2, n-1, m-1);
        } else {
            return t[n][m] = Math.max(longestCommonSubsequence(t, t1,t2,n-1,m),
                           longestCommonSubsequence(t, t1,t2,n,m-1));
        }
    }
    
//     public int longestCommonSubsequence(int[][] t, char[] t1, char[] t2) {
//         for(int i=0; i<t.length; i++) t[i][0] = 0;
//         for(int i=0; i<t[0].length; i++) t[0][i] = 0;
                
//         for(int i=1; i<t.length; i++) {
//             for(int j=1; j<t[0].length; j++) {
//                 if(t1[i-1] == t2[j-1]) {
//                     t[i][j] = 1+t[i-1][j-1];
//                 } else {
//                     t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
//                 }
//             }
//         }
//         return t[t.length-1][t[0].length-1];
//     }
}