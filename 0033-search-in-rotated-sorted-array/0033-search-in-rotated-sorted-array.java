class Solution {
    public int search(int[] nums, int target) {
//         int low=0, high=nums.length-1;
//         while(low<=high) {
//             int mid=(low+(high-low)/2);
            
//             if(nums[mid]==target) return mid;
            
//             //                      /\    
//             //                     /  \  /
//             // array graph =           \/
            
//             //                      /
//             //                     /
//             // left is sorted -   /   (graph)
//             if(nums[mid]>nums[high]) {
//                 if(target>=nums[low] && target<=nums[mid]) high=mid-1;
//                 else low=mid+1;
//             }
            
//             //                       /
//             //                      /
//             // right is sorted -   /   (graph)
//             else {
//                 if(target>=nums[mid] && target<=nums[high]) low=mid+1; 
//                 else high=mid-1;
//             }
//         }
//         return -1;
        
        
        int minIndex = findMin(nums);
        int left = search(nums, 0, minIndex, target);
        int right = search(nums, minIndex, nums.length-1, target);
        int ans = left==-1 && right==-1 ? -1 : (left!=-1 ? left : right);
        return ans;
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