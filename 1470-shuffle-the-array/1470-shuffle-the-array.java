class Solution {
    public int[] shuffle(int[] nums, int n) {
        // n, n
        // int[] ans = new int[ 2 * n];
        // for (int i = 0; i < n; ++i) {
        //     ans[2 * i] = nums[i];
        //     ans[2 * i + 1] = nums[i + n];
        // }
        // return ans;
        
        
        // n,1
        for(int i = 0; i < n; i++){
            nums[i] += nums[n + i] * 10000;
        }
        
        //System.out.println(Arrays.toString(nums));
        
        for(int i = n - 1; i >= 0; i--){
            nums[2 * i + 1] = nums[i] / 10000;
            //System.out.println(Arrays.toString(nums));
            nums[2 * i] = nums[i] % 10000;
            //System.out.println(Arrays.toString(nums));
        }
        
        
        
        return nums;
    }
}