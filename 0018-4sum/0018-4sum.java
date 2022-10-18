class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;
        int n = nums.length;
        Arrays.sort(nums);
        
        // traverse 0 to n-1
        for(int i=0;i<n;i++) {
            // traverse i+1 to n-1
            for(int j=i+1;j<n;j++) {
                // 2 pointers for finding new target
                // int newTarget = target-nums[i]-nums[j];
        
                // twoSumBrute(nums, i, res);
                twoSum(nums, i, j, res, target);
                // twoSumII(nums, i, j, res, target);
                while(j+1<n && nums[j+1]==nums[j]) ++j;
            }
            // skip duplicates in i
            while(i+1<n && nums[i+1]==nums[i]) ++i;
        }
        return res;
        
        
//         Set<List<Integer>> set = new HashSet<>();
//         List<List<Integer>> res = new ArrayList<>();
//         if(nums==null || nums.length==0) return res;
//         int n = nums.length;
//         Arrays.sort(nums);
        
//         long average_value = target / 4;
//         if  (nums[0] > average_value || average_value > nums[nums.length - 1]) {
//             return res;
//         }
//         if  (nums[0] > average_value || average_value > nums[nums.length - 1]) {
//             return res;
//         }
        
//         for(int i=0;i<n-3;i++) {
//             for(int j=i+1;j<n-2;j++) {
//                 for(int k=j+1;k<n-1;k++) {
//                 int newTarget = target-nums[i]-nums[j]-nums[k];
                
//                 if(search(nums,k+1,n-1,newTarget)) {
//                     List<Integer> quad = Arrays.asList(nums[i],nums[j],nums[k],newTarget);
//                     res.add(quad);
                    
//                     while(k+1<n && nums[k+1]==nums[k]) ++k;
//                 }
//                 while(j+1<n && nums[j+1]==nums[j]) ++j;
//             }
//             while(i+1<n && nums[i+1]==nums[i]) ++i;
//         }
//     }
//     return res;
}
    
    void twoSum(int[] nums, int i, int j, List<List<Integer>> res, long target) {
        Set<Long> seen = new HashSet<>();
        for (int k = j + 1; k < nums.length; ++k) {
            long complement = target - nums[i] - nums[j] - nums[k];
            if (seen.contains(complement)) {
                res.add(Arrays.asList(nums[i], nums[j], nums[k], (int)complement));
                while (k + 1 < nums.length && nums[k] == nums[k + 1]) ++k;
            }
            seen.add((long)nums[k]);
        }
    }
    
    void twoSumII(int[] nums, int i, int j, List<List<Integer>> res, long target) {
        int lo = j + 1, hi = nums.length - 1;
        while (lo < hi) {
            long sum = (long)nums[i] + nums[j] + nums[lo] + nums[hi];
            
            if (sum < target) {
                ++lo;
            } else if (sum > target) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[i], nums[j], nums[lo++], nums[hi--]));
                while (lo < hi && nums[lo] == nums[lo - 1]) ++lo;
                while (lo < hi && nums[hi] == nums[hi + 1]) --hi;
            }
        }
    }
    
    public boolean search(int[] nums,int start, int end, int target) {
        int low = start, high = end, mid;
        while(low<=high) {
            mid = (low +(high-low)/2);
            if(nums[mid] == target) return true;
            else if(nums[mid]<target) low = mid+1;
            else high = mid-1;
        }
        return false;
    }
}