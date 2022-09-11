class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        if(n<=1) return true;
        
        int nonseq=0;
        for(int i=0; i<n; i++) 
        {
            if(nums[i] > nums[(i+1)%n]) {
                if(nonseq==1) return false;
                nonseq++;
            }
        }
        return true;
    }
}