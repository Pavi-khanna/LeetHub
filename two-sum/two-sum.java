class Solution {
    public int[] twoSum(int[] nums, int target) {
        // n^2, 1
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[j] == target - nums[i]) {
        //             return new int[] { i, j };
        //         }
        //     }
        // }
        // return null;
        
        
        // n, n
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int secondNum = target-nums[i];
            if(map.containsKey(secondNum)) {
                return new int[] {map.get(secondNum), i};   // in order
            }
            map.put(nums[i], i);
        }
        return null;
    }
}