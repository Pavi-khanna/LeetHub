class Solution {
    public int subarraySum(int[] nums, int k) {
        // n^2, 1
        // int count = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     int sum=0;
        //     for (int j = i; j < nums.length; j++) {
        //         sum+=nums[j];
        //         if (sum == k)
        //             count++;
        //     }
        // }
        // return count;
        
        
        // n, n
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return result;
        
        
        // n, 1 only pos nos
//         int i=0, j=0, max=0, sum=0, count=0;
//         if(nums.length == 1 && nums[0] != k) return count; 
        
//         while(j<nums.length) {
//             sum += nums[j];
            
//             if(sum > k) {
//                 while(sum>k){
//                     sum = sum - nums[i];
//                     i++;
//                     if(sum==k){
//                         max = Math.max(max,(j-i+1));
//                         count++;
//                     }
//                 }
//             } else if(sum == k) {
//                 max = Math.max(max, j-i+1);
//                 count++;
//             }
            
//             j++;
//         }
//         return count;
    }
}