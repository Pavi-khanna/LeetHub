class Solution {
    public int missingNumber(int[] nums) {
        // nlogn, n
//         Arrays.sort(nums);
//         if (nums[nums.length-1] != nums.length) {
//             return nums.length;
//         } else if (nums[0] != 0) {
//             return 0;
//         }
//         for(int i=1;i<nums.length;i++) {
//             if(nums[i] != nums[i-1]+1) {
//                 return nums[i-1]+1;
//             }
//         }
//         return -1;
        
        
        // n, n
//         Set<Integer> numSet = new HashSet<>();
//         for(int num : nums) numSet.add(num);
//         for(int i=0; i<=nums.length; i++) {
//             if(!numSet.contains(i)) return i;
//         }
//         return -1;
        
        
        // n, 1
        // int n = nums.length;
        // int sum = n*(n+1)/2;
        // for(int i=0; i<nums.length; i++) {
        //     sum -= nums[i];
        // }
        // return sum;
        
        
        // n, 1
        // int sum = 0;
        // for(int i=1; i<=nums.length; i++) {
        //     sum += i;
        //     sum -= nums[i-1];
        // }
        // return sum;
        
        
        int xor1 = 0, xor2 = 0;
        for(int i=1; i<=nums.length; i++) {
            xor1 ^= i;
            xor2 ^= nums[i-1];
        }
        return xor1^xor2;
    }
}