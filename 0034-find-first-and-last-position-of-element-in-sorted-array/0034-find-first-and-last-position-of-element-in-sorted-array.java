class Solution {
    public int[] searchRange(int[] nums, int target) {
        // boolean isFirst = false;
        // int first=-1, last=-1;
        // for(int i=0; i<nums.length; i++) {
        //     if(nums[i]==target) {
        //         if(!isFirst) { first = i; isFirst=true; }
        //         last = i;
        //     }
        // }
        // return new int[]{first, last};
        
        
        int first = first(nums, target, true);
        
        if(first == -1) {
            return new int[] {-1, -1};
        }
        
        int last = first(nums, target, false);
        return new int[]{first, last};
    }
    
    public int first(int[] nums, int target, boolean isFirst) {
        int start = 0, end = nums.length-1, first=-1;
        int mid = 0;
        
        while(start <= end) {
            mid = start + (end-start)/2;
            
            if(nums[mid]==target) {
                first = mid;
                if(isFirst) end = mid-1;
                else start = mid+1;
            } else if(nums[mid]<target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return first;
    }
    
//     public int last(int[] nums, int target) {
//         int start = 0, end = nums.length-1, last=-1;
//         int mid = start + (end-start)/2;
        
//         while(start <= end) {
//             mid = start + (end-start)/2;
            
//             if(nums[mid]==target) {
//                 last = mid;
//                 start = mid+1;
//             } else if(nums[mid]<target) {
//                 start = mid+1;
//             } else {
//                 end = mid-1;
//             }
//         }
//         return last;
//     }
}