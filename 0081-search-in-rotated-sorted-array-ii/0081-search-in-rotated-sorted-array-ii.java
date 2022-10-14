class Solution {
    public boolean search(int[] nums, int target) {
        // logn to n(90% duplicates), 1
        int low=0,high=nums.length-1;
        while(low<=high) {
            while (low < high && nums[low] == nums[low + 1])
                ++low;
            while (low < high && nums[high] == nums[high - 1])
                --high;
            
            int mid=(low+high)>>1;
            if(nums[mid]==target) return true;
            
            // left sorted
            if(nums[mid]>=nums[high]) {
                if(target>=nums[low] && target<=nums[mid]) high=mid-1;
                else low=mid+1;
            }
            // right is sorted 
            else {
                if(target>=nums[mid] && target<=nums[high]) low=mid+1; 
                else high=mid-1;
            }
        }
        return false;
    }
}