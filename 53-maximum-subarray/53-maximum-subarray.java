class Solution {
    public int maxSubArray(int[] nums) {
        // n^2, 1
        // int max = Integer.MIN_VALUE;
        // for(int i=0; i<nums.length; i++) {
        //     int curMax = 0;
        //     for(int j=i; j<nums.length; j++) {  // if i+1 -> i/p 1 => o/p int min -2147483648
        //         curMax+=nums[j];
        //         max = Math.max(curMax, max);
        //     }
        // }
        // return max;
        
        
        // n, 1
        // agar sb pos h toh toh aage jaane pe max sum hi milega km kaise hoga sum? jb neg milenge elements and jn sum hi neg m chla jae toh usse chati ka bojh bnane ki zarurat nhi h vhin chd do usse and move on
        int max = Integer.MIN_VALUE, sum = 0, begin = 0, end = 0, start = 0;
        for(int i=0; i<nums.length;i++) {
            sum += nums[i];
            // if(max<sum) {
            //     max = sum;
            //     start = begin;
            //     end = i;
            // }
            // if(sum<0) {
            //     sum = 0;
            //     begin = i+1;
            // }
            max = Math.max(sum, max);
            if(sum<0) sum = 0;
        }
        // System.out.println(Arrays.toString(Arrays.copyOfRange(nums, start, end+1)));
        return max;
    }
}