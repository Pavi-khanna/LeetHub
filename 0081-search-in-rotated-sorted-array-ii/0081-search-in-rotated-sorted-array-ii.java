class Solution {
    public boolean search(int[] nums, int target) {
        // logn to n(90% duplicates), 1
//         int low=0,high=nums.length-1;
//         while(low<=high) {
//             while (low < high && nums[low] == nums[low + 1])
//                 ++low;
//             while (low < high && nums[high] == nums[high - 1])
//                 --high;
            
//             int mid=(low+high)>>1;
//             if(nums[mid]==target) return true;
            
//             // left sorted
//             if(nums[mid]>nums[high]) {
//                 if(target>=nums[low] && target<=nums[mid]) high=mid-1;
//                 else low=mid+1;
//             }
//             // right is sorted 
//             else {
//                 if(target>=nums[mid] && target<=nums[high]) low=mid+1; 
//                 else high=mid-1;
//             }
//         }
//         return false;
        
        
        int minIndex = findMin(nums);
        int left = search(nums, 0, minIndex, target);
        int right = search(nums, minIndex, nums.length-1, target);
        int ans = left==-1 && right==-1 ? -1 : (left!=-1 ? left : right);
        return ans!=-1 ? true : false;
    }
    
    public int search(int[] nums, int start, int end, int target) {
        int low = start, high = end, mid;
        while(low<=high) {
            mid = (low +(high-low)/2);
            
            if(nums[mid] == target) return mid;
            else if(nums[mid]<target) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
    
    public int findMin(int[] nums) {
        int start = 0, end = nums.length-1, mid = start + (end-start)/2;
        if(nums == null || nums.length == 0) return -1;
        
        while(start <= end) {   // 2,1 => 1
            while (start < end && nums[start] == nums[start + 1]) ++start;
            while (start < end && nums[end] == nums[end - 1]) --end;
            
            mid = start + (end-start)/2;
            
            // left side
            if(nums[mid] < nums[end]) {
                end = mid;
            } else { // right side
                start = mid + 1;
            }
        }
        return mid;
    }
}