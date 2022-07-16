class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for(int num : nums) totalSum += num;
        int sum = (target+totalSum)/2;
        if((target+totalSum)%2!=0 || sum<0) return 0;
        // return findTargetSumWays(nums.length, nums, sum);
        int t[][] = new int[nums.length+1][sum+1];
        for(int i=0; i<nums.length+1; i++) {
            Arrays.fill(t[i], -1);
        }
        return findTargetSumWays(t, nums.length, nums, sum);
    }
    
    public int findTargetSumWays(int n, int[] arr, int sum) {
         if(n==0) {
             if(sum!=0) return 0;
             else return 1;
         }
         
         if(arr[n-1] > sum) {
             return findTargetSumWays(n-1, arr, sum);
         } else {
             return findTargetSumWays(n-1, arr, sum-arr[n-1]) + findTargetSumWays(n-1, arr, sum);
         }
    }
    
    public int findTargetSumWays(int[][] t, int n, int[] arr, int sum) {
        if(n==0) {
             if(sum!=0) return 0;
             else return 1;
         }
        
        if(t[n][sum] != -1) return t[n][sum];
         
         if(arr[n-1] > sum) {
             return t[n][sum] = findTargetSumWays(n-1, arr, sum);
         } else {
             return t[n][sum] = findTargetSumWays(n-1, arr, sum-arr[n-1]) +
                 findTargetSumWays(n-1, arr, sum);
         }
    }
}