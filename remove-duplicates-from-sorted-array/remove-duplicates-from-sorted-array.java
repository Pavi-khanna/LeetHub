class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        
        int uniqueElement=0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i]!=nums[uniqueElement]) {
                nums[++uniqueElement]=nums[i];
            }
        }
        return uniqueElement+1;
    }
}