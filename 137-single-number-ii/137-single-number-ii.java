class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int num = 0;
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i]==nums[i+1]) i+=2;
            else return nums[i];
        }
        return nums[nums.length-1];
    }
}