class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int[] diff = {Integer.MAX_VALUE};
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && diff[0] != 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i]) {
                // twoSumBrute(nums, i, res);
                // twoSum(nums, i, res);
                twoSumII(nums, i, res, target, diff);
            }
        return target-diff[0];
    }
    
    void twoSumII(int[] nums, int i, List<List<Integer>> res, int target, int[] diff) {
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (Math.abs(target-sum) < Math.abs(diff[0])) {
                diff[0] = target-sum;
            } else if (sum > target) {
                --hi;
            } else {
                // res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                // while (lo < hi && nums[lo] == nums[lo - 1]) ++lo;
                ++lo;
            }
        }
    }
}