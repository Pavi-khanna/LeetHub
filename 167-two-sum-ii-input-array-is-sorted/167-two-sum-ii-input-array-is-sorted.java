class Solution {
    public int[] twoSum(int[] nums, int target) {
//         int[] res = new int[2];
//         int lo = 0, hi = nums.length - 1;
//         while (lo < hi) {
//             int sum = nums[lo] + nums[hi];
            
//             if (sum == target) {
//                 // while (lo < hi && nums[lo] == nums[lo - 1]) ++lo;
//                 return new int[]{lo+1, hi+1};
//             } else if (sum < target) {
//                 ++lo;
//             } else {
//                 --hi;
//             }
//         }
//         return new int[0];
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int secondNum = target-nums[i];
            if(map.containsKey(secondNum)) {
                return new int[] {map.get(secondNum)+1, i+1};   // in order
            }
            map.put(nums[i], i);
        }
        return null;
    }
}