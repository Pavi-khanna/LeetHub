class Solution {
    public int missingElement(int[] nums, int k) {
        int count=0;
        for(int i=1; i<nums.length; i++) {
            count = nums[i]-nums[i-1]-1;
            if(count>=k) return nums[i-1]+k;
            k-=count;
        }
        return nums[nums.length-1]+k;
    }
}