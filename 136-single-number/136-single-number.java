class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int num = 0;
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i]==nums[i+1]) i++;
            else return nums[i];
        }
        return nums[nums.length-1];
        
        
        
        // int ans = nums[0];
        // for(int i=1; i<nums.length; i++) {
        //     ans ^= nums[i];
        // }
        // return ans;
    }
}