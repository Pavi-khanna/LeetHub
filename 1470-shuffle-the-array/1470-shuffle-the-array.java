class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] even = new int[nums.length/2];
        for(int i=0; i<even.length; i++) {
            even[i] = nums[i];
        }
        
        int j = nums.length/2;
        for(int i=1; i<nums.length && j<nums.length; i+=2) {
            nums[i-1] = even[j-n];
            nums[i] = nums[j];
            j++;
        }
        return nums;
    }
}