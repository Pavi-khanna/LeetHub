class Solution {
    public double myPow(double x, int n) {
        // n, 1
        // long N = n;
        // if (N < 0) {
        //     x = 1 / x;
        //     N = -N;
        // }
        // double ans = 1;
        // for (long i = 0; i < N; i++)
        //     ans = ans * x;
        // return ans;
        
        
        double ans = 1.0;
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        while(N>0){
            if(N%2 == 1) {
                ans = ans*x;
                N=N-1;
            } else {
                x=x*x;
                N=N/2;
            }
        }
        return ans;
        
        // return halfPow(x, N);
    }
    
    // public double halfPow(double x, long N) {
    //     if(N==0) return 1.0;
    //     double temp = halfPow(x, N/2);
    //     if(N%2 == 1) return temp*temp*x;
    //     return temp*temp;
    // }
}