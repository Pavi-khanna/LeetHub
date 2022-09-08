class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        // return Math.min(climbStairs(n-1, cost),climbStairs(n-2, cost));
        
        // int[] cache = new int[n];
        // Arrays.fill(cache, -1);
        // cache[0] = cost[0];
        // cache[1] = cost[1];
        // return Math.min(climbStairs(n-1, cost, cache),climbStairs(n-2, cost, cache));
        
        
        int first=cost[0], second=cost[1];
        if(n<=1) return Math.min(first, second);
        for(int i=2; i<n; i++) {
            int curr = cost[i] + Math.min(first, second);
		    first = second;
		    second = curr;
        }
        return Math.min(first, second);
    }
    
    public int climbStairs(int n, int[] cost) {
        if(n<=1) return cost[n];
        
        return cost[n] + Math.min(climbStairs(n-1, cost), climbStairs(n-2, cost));
    }
    
    public int climbStairs(int n, int[] cost, int[] t) {
        if(n<=1) return cost[n];
        
        if(t[n]!=-1) return t[n];
        
        return t[n] = cost[n] + Math.min(climbStairs(n-1, cost, t), climbStairs(n-2, cost, t));
    }
}