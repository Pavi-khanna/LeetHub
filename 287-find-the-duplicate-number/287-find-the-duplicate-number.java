class Solution {
    public int findDuplicate(int[] nums) {
        // nlogn, logn
        // Arrays.sort(nums);
        // for (int i = 1; i < nums.length; i++) {
        //     if (nums[i] == nums[i-1])
        //         return nums[i];
        // }
        // return -1;
        
        
        // n, n
        // Set<Integer> seen = new HashSet<Integer>();
        // for (int num : nums) {
        //     if (seen.contains(num))
        //         return num;
        //     seen.add(num);
        // }
        // return -1;
        
        
        // n, 1
        // move until fast and slow collide
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(fast != slow);
        
        // move till the entrance to find duplicate
        fast = nums[0];
        while(fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        // System.out.println(nums[slow]);
        return slow;
    }
}