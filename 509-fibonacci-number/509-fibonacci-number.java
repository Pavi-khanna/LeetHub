class Solution {
    public int fib(int n) {
        if(n<=1) return n;
        
        // 2^n,n
       // return fib(n-1)+fib(n-2);
        
        
        // n, n
        int[] cache = new int[n+1];
        cache[1] = 1;
        for(int i=2; i<=n; i++) {
            cache[i] = cache[i-1]+cache[i-2];
        }
        return cache[n];
        
        
        // n,1
//         int first=0, second=1, current=0;
        
//         for(int i=2; i<=n; i++) {
//             current = first+second;
//             first = second;
//             second = current;
//         }
//         return current;
        
        
        // logn, 1
        // double goldenRatio = (1+Math.sqrt(5))/2;
        // return (int) Math.round(Math.pow(goldenRatio, n) / Math.sqrt(5));
    }
}