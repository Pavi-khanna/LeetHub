class Solution {
    public boolean containsDuplicate(int[] nums) {
        // n^2
        // for (int i = 0; i < nums.length; ++i) {
        //    for (int j = i+1; j < nums.length; ++j) {
        //        if (nums[j] == nums[i]) return true;  
        //    }
        // }
        // return false;
        
        
        // nlogn
        // Arrays.sort(nums);
        // int n = nums.length;
        // for(int i=0; i<n-1;i++){
        //     if(nums[i]==nums[i+1]) {
        //         return true;
        //     }
        // }
        // return false;
        
        
        // n,n
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
        
        
        // n,n
        // Set<Integer> set = new HashSet<>();
        // for(int num : nums) {
        //     set.add(num);
        // }
        // return set.size()<nums.length ? true : false;
    }
}