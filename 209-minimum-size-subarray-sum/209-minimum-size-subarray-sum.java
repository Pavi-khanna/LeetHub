class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // n^2, 1
        // int minLength = Integer.MAX_VALUE;
        // for(int i=0; i<nums.length; i++) {
        //     int curSum = 0;
        //     for(int j=i; j<nums.length; j++) {  // if i+1 -> 1 = int min
        //         curSum+=nums[j];
        //         if(curSum >= target) {
        //             minLength = Math.min(j-i+1, minLength);
        //             break;
        //         }
        //     }
        // }
        // return minLength == Integer.MAX_VALUE ? 0 : minLength;
        
        
        // n^2, n
        // int minLength = Integer.MAX_VALUE;
        // int[] sums = new int[nums.length];
        // sums[0] = nums[0];
        // for(int i=1; i<nums.length; i++) {
        //     sums[i] = sums[i-1]+nums[i];
        // }
        // for(int i=0; i<nums.length; i++) {  // if i+1 -> 1 = int min
        //     for(int j=i; j<nums.length; j++) {
        //         int curSum = sums[j]-sums[i]+nums[i];
        //         if(curSum >= target) {
        //             minLength = Math.min(j-i+1, minLength);
        //             break;
        //         }
        //     }
        // }
        // return minLength == Integer.MAX_VALUE ? 0 : minLength;
        
        
        // nlogn, 1 - only for pos no array - binary search
//         int minLength = Integer.MAX_VALUE;
        
//         for(int i=0; i<nums.length; i++) {
//             if(i>0) nums[i]+=nums[i-1];
//             if(nums[i]<target) continue;
            
//             int closestIndex = binarySearch(nums, i, target);
//             minLength = Math.min(minLength, i-closestIndex+1);
//         }
//         return minLength == Integer.MAX_VALUE ? 0 : minLength;
        
        
        // n, 1 - sliding window
        int i=0, j=0, sum=0, minLength=Integer.MAX_VALUE;
        
        while(j < nums.length) {
            sum += nums[j];
            
            while(sum >= target) {
                minLength = Math.min(minLength, j-i+1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
    
    public int binarySearch(int[] nums, int end, int target) {
        int start = 0, total = nums[end];
        while(start <= end) {
            int mid = start + (end-start)/2;
            int diff = total - nums[mid];
            
            if(diff==target) return mid+1;
            if(diff>target) start = mid+1;
            else end = mid-1;
        }
        return start;
    }
}