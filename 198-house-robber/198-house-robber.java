class Solution {
    public int rob(int[] nums) {
        int[] h = new int[nums.length+1];
        Arrays.fill(h, -1);
        return robber(nums.length-1, nums, h);
    }
    
    public int robber(int i, int[] nums, int[] h) {
        if(i<0) return 0;
        
        if(h[i]!=-1) return h[i];
        
        return h[i] = Math.max(robber(i-2, nums,h)+nums[i], robber(i-1, nums,h));
    }
}