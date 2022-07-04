class Solution {
    public int reverse(int x) {
        int n = x, reverse = 0;
        while(n!=0) {
            int unit = n%10;
            if (reverse > Integer.MAX_VALUE/10 || (reverse == Integer.MAX_VALUE / 10 && unit > 7)) return 0;
            if (reverse < Integer.MIN_VALUE/10 || (reverse == Integer.MIN_VALUE / 10 && unit < -8)) return 0;
            reverse = reverse*10+unit;
            n/=10;
        }
        return reverse;
    }
}