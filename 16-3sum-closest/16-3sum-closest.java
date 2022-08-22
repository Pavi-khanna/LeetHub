class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int[] ans = {Integer.MAX_VALUE};
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i)
            if (i == 0 || nums[i - 1] != nums[i]) {
                // twoSumBrute(nums, i, res);
                // twoSum(nums, i, res);
                twoSumII(nums, i, res, target, ans);
            }
        return ans[0];
    }
    
    void twoSumII(int[] nums, int i, List<List<Integer>> res, int target, int[] ans) {
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (Math.abs(target-sum) < Math.abs(ans[0]-target)) {
                // res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                // while (lo < hi && nums[lo] == nums[lo - 1]) ++lo;
                ans[0] = sum;
            } 
            
            if(sum == target) {
                ans[0] = target;
                break;
            } else if (sum > target) {
                --hi;
            } else {
                ++lo;
            }
        }
    }
}