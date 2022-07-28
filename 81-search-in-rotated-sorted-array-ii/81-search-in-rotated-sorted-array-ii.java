class Solution {
    public boolean search(int[] nums, int target) {
        int low=0,high=nums.length-1;
        while(low<=high) {
            int mid=(low+high)>>1;
            if(nums[mid]==target) return true;
            
            // left sorted
            if (nums[low] == nums[mid] && nums[high] == nums[mid]) {
                low++;
                high--;
            }
            else if(nums[low]<=nums[mid]) {
                if(target>=nums[low] && target<=nums[mid]) high=mid-1;
                else low=mid+1;
            }
            
            //                       /
            //                      /
            // right is sorted -   /   (graph)
            else {
                if(target>=nums[mid] && target<=nums[high]) low=mid+1; 
                else high=mid-1;
            }
        }
        return false;
    }
}