class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        int start =0, end = nums.length-1, mid=0, peak = 0, size = nums.length;
        
        if(nums.length==1) return 0;
        
        while(start <= end) {
            mid = start +(end-start)/2;
            
            // if(nums[mid] < nums[mid+1]) {
            //     start = mid+1;
            // } else {
            //     end = mid;
            // }
            
            if(mid > 0 && mid < nums.length - 1) {
                if(nums[mid] >= nums[mid - 1] && nums[mid] >= nums[mid + 1])
                    return mid;
                else if (nums[mid] < nums[mid - 1])
                    end = mid - 1;
                else
                    start = mid + 1;
            }else if(mid == 0) {
                if(nums[mid] >= nums[mid + 1]) return mid;
                else return mid + 1;
            }else {
                if(nums[mid] >= nums[mid - 1]) return mid;
                else return mid - 1;
            } 
        }
        return start;
    }
}