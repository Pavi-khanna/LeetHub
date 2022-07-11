class Solution {
    public int kthGrammar(int n, int k) {
//         if(n==0) return 0;
//         if(n==1 && k==1) return 0;
        
//         int mid = (int)Math.pow(2, n-1);
        
//         if(k<=mid) {
//             return kthGrammar(n-1, k);
//         } else {
//             return kthGrammar(n-1, k-mid) ^ 1;
//         }
        
        return Integer.bitCount(k-1) & 1;
    }
}