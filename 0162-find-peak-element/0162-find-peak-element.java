class Solution {
    public int findPeakElement(int[] nums) {
        // n, 1
        // for (int i = 0; i < nums.length - 1; i++) {
        //     if (nums[i] > nums[i + 1])
        //         return i;
        // }
        // return nums.length - 1;
        
        
        // logn, 1
        int start =0, end = nums.length-1, mid=0, peak = 0, size = nums.length;
        if(nums.length==1) return 0;
        while(start < end) {
            mid = start + (end-start)/2;
            
            if(nums[mid] < nums[mid+1]) { // left of mountain
                start = mid+1;
            } else {
                end = mid;
            }
            
            // if(mid > 0 && mid < nums.length - 1) {
            //     if(nums[mid] >= nums[mid - 1] && nums[mid] >= nums[mid + 1])
            //         return mid;
            //     else if (nums[mid] < nums[mid - 1])
            //         end = mid - 1;
            //     else
            //         start = mid + 1;
            // }else if(mid == 0) { // first ele
            //     if(nums[mid] >= nums[mid + 1]) return mid;
            //     else return mid + 1;
            // }else {              // last ele
            //     if(nums[mid] >= nums[mid - 1]) return mid;
            //     else return mid - 1;
            // } 
        }
        return start;
    }
}