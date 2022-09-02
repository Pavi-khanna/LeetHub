class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // n^2, 1
        // for(int i=0;i<nums.length;i++) {
        //     for(int j=i+1;j<nums.length;j++) {
        //         if(nums[i] == nums[j] && Math.abs(i-j) <= k) {
        //             return true;
        //         }
        //     }
        // }
        // return false;
        
        
        // n, min(n,k)
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            if(set.contains(num)) {
                return true;
            }
            set.add(num);
            
            if(set.size()>k) {
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}