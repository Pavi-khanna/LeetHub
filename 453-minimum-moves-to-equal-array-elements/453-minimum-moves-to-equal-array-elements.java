class Solution {
    public int minMoves(int[] nums) {
        // n^2k, 1
        // int min = 0, max = nums.length - 1, count = 0;
        // while (true) {
        //     for (int i = 0; i < nums.length; i++) {
        //         if (nums[max] < nums[i]) {
        //             max = i;
        //         }
        //         if (nums[min] > nums[i]) {
        //             min = i;
        //         }
        //     }
        //     if (nums[max] == nums[min]) {
        //         break;
        //     }
        //     for (int i = 0; i < nums.length; i++) {
        //         if (i != max) {
        //             nums[i]++;
        //         }
        //     }
        //     count++;
        // }
        // return count;
        
        
        // n^2, 1
        // int min = 0, max = nums.length - 1, count = 0;
        // while (true) {
        //     for (int i = 0; i < nums.length; i++) {
        //         if (nums[max] < nums[i]) {
        //             max = i;
        //         }
        //         if (nums[min] > nums[i]) {
        //             min = i;
        //         }
        //     }
        //     int diff = nums[max] - nums[min];
        //     if (diff==0) {
        //         break;
        //     }
        //     for (int i = 0; i < nums.length; i++) {
        //         if (i != max) {
        //             nums[i]+=diff;
        //         }
        //     }
        //     count+=diff;
        // }
        // return count;
        
        
        // nlogn, 1
        Arrays.sort(nums);
        int count=0;
        for(int i=nums.length-1; i>=0; i--) {
            count += nums[i]-nums[0];
        }
        return count;
    }
}