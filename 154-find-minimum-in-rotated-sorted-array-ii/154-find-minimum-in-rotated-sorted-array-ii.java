class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length-1, mid = start + (end-start)/2;
        
        if(nums == null || nums.length == 0) return -1;
        
        while(start <= end) {
            while (start < end && nums[start] == nums[start + 1])
                ++start;
            while (start < end && nums[end] == nums[end - 1])
                --end;
            mid = start + (end-start)/2;
            
            // we just have to go to the rotated side doesn't matter if its on the left or right bcz the min                element lies on that side only and accd to the graph of rotated sorted array the unsorted                    side is the rotated one.
            //                      /\    
            //                     /  \  /
            // array graph =           \/
            
            
            // left side
            if(nums[mid] < nums[end]) {
                end = mid;
            } else { // right side
                start = mid + 1;
            }
        }
        return nums[mid];
    }
}