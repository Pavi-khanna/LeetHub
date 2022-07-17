class Solution {
    public int coinChange(int[] coins, int amount) {
        // int ans = coinChange(coins.length, amount, coins);
        // return ans == Integer.MAX_VALUE-1 ? -1 : ans;
        
        
        int n = coins.length;
        int[][] t = new int[n+1][amount+1];
        // for(int i=0; i<n+1; i++) {
        //     Arrays.fill(t[i], -1);
        // }
        // int ans = coinChange(t, n, amount, coins);
        // return ans == Integer.MAX_VALUE-1 ? -1 : ans;
        
        
        int ans = coinChange(t, coins);
        return ans == Integer.MAX_VALUE-1 ? -1 : ans;
    }
    
    public int coinChange(int n, int W, int[] coins) {
        // if(n==1) {
        //     if(W%coins[n-1] == 0) return W/coins[n-1];
        //     else return Integer.MAX_VALUE-1;
        // }
        if(n==0) {
             if(W==0) return 0;
             else return Integer.MAX_VALUE-1;
         }
         
         if(coins[n-1] > W) {
             return coinChange(n-1, W, coins);
         } else {
             return Math.min(1+coinChange(n, W-coins[n-1], coins) , coinChange(n-1, W, coins));
         }
    }
    
    public int coinChange(int[][] t, int n, int W, int[] coins) {
        if(n==0) {
             if(W==0) return 0;
             else return Integer.MAX_VALUE-1;
         }
        
        if(t[n][W] != -1) return t[n][W];
         
         if(coins[n-1] > W) {
             return t[n][W] = coinChange(t, n-1, W, coins);
         } else {
             return t[n][W] = Math.min(1+coinChange(t, n, W-coins[n-1], coins),
                             coinChange(t, n-1, W, coins));
         }
    }
    
    static int coinChange(int[][] t, int coins[]) {
         int rows = t.length, cols = t[0].length;
         for(int j=0; j<cols; j++) t[0][j] = Integer.MAX_VALUE-1;
         for(int i=0; i<rows; i++) t[i][0] = 0;
         
         for(int i=1; i<rows; i++) {
             for(int j=1; j<cols; j++) {
                 if(coins[i-1] > j) {
                    t[i][j] = t[i-1][j];
                 } else {
                    t[i][j] =   Math.min(1+t[i][j-coins[i-1]] , t[i-1][j]);
                 }
             }
         }
         return t[rows-1][cols-1];
    } 
}