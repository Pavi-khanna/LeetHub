class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n<=1) return n;
        
        int first=0, second=0, current=0;
        
        for(int i=2; i<=n; i++) {
            current = first;
            first = Math.min(first+cost[i-1], second+cost[i-2]);
            second = current;
        }
        return first;
    }
}