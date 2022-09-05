class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        // n^2, 1
        // for(int i=0;i<nums.length;i++) {
        //     for(int j=i+1;j<nums.length;j++) {
        //         if(nums[i]==nums[j]) {
        //             ans.add(nums[i]);
        //             break;
        //         }
        //     }
        // }
        // return ans;
        
        
        // nlogn, 1
        // sort and compare while looping and add to our list
        // Arrays.sort(nums);
        // for(int i=0;i<nums.length-1;i++) {
        //     if(nums[i]==nums[i+1]) {
        //         ans.add(nums[i]);
        //     }
        // }
        // return ans;
        
        
        // n, n
        Set<Integer> seen = new HashSet<>();
        for(int num : nums) {
            if(seen.contains(num)) {
                ans.add(num);
            } else 
                seen.add(num);
        }
        return ans;
    }
}