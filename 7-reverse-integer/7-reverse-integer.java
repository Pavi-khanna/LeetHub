class Solution {
    public int reverse(int x) {
        int n = x, reverse = 0;
        while(n!=0) {
            int unit = n%10;
            if (reverse > Integer.MAX_VALUE/10) return 0;
            if (reverse < Integer.MIN_VALUE/10) return 0;
            reverse = reverse*10+unit;
            n/=10;
        }
        return reverse;
        
//         2147483647
//         214748364
//         2147483648
            
//         -2147483648
//         -214748364
//         -2147483648
    }
}