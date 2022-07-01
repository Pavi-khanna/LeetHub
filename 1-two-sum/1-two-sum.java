class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            int secondNum = target-nums[i];
            if(map.containsKey(secondNum)) {
                return new int[] {i, map.get(secondNum)};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}