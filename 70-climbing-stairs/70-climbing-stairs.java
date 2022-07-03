class Solution {
    public int climbStairs(int n) {
        if(n<=1) return n;
        
        int first=1, second=1, current=0;
        
        for(int i=2; i<=n; i++) {
            current = first+second;
            first = second;
            second = current;
        }
        return current;
    }
}