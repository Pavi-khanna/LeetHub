class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for(int num : nums) totalSum += num;
        int sum = (target+totalSum)/2;
        if((target+totalSum)%2!=0) return 0;
        return findTargetSumWays(nums.length, nums, sum);
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
}