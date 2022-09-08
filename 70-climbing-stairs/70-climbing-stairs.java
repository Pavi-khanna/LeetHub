class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;
        
        
        // return climbStairs(n-1)+climbStairs(n-2);
        
        
        // n, n
        int[] cache = new int[n+1];
        cache[1] = 1;
        cache[2] = 2;
        for(int i=3; i<=n; i++) {
            cache[i] = cache[i-1]+cache[i-2];
        }
        return cache[n];
        
        
//         int first=1, second=1, current=0;
        
//         for(int i=2; i<=n; i++) {
//             current = first+second;
//             first = second;
//             second = current;
//         }
//         return current;
    }
}