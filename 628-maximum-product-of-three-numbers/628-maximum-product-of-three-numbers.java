class Solution {
    public int maximumProduct(int[] nums) {
        // n^3, 1
        // int n = nums.length, max = Integer.MIN_VALUE;
        // for(int i=0; i<n; i++) {
        //     for(int j=i+1; j<n; j++) {
        //         for(int k=j+1; k<n; k++) {
        //             max = Math.max(max, nums[i]*nums[j]*nums[k]);
        //         }
        //     }
        // }
        // return max;
        
        
        // nlogn, logn
        int n = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[0]*nums[1]*nums[n-1], nums[n-1]*nums[n-2]*nums[n-3]);
    }
}