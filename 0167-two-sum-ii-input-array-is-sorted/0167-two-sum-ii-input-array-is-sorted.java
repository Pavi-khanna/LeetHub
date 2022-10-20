class Solution {
    public int[] twoSum(int[] nums, int target) {
        // n, 1
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int sum = nums[lo] + nums[hi];
            
            if (sum == target) {
                // while (lo < hi && nums[lo] == nums[lo - 1]) ++lo;
                return new int[]{lo+1, hi+1};
            } else if (sum < target) {
                ++lo;
            } else {
                --hi;
            }
        }
        return new int[0];
    }
}