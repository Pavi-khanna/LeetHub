class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum=0;
            for (int j = i; j < nums.length; j++) {
                sum+=nums[j];
                if (sum == k)
                    count++;
            }
        }
        return count;
        
        
        
//         Map<Integer, Integer> count = new HashMap<>();
//         count.put(0,1);
//         int prefixSum = 0, answer = 0;
        
//         for(int num : nums) {
//             prefixSum += num;
//             answer += count.getOrDefault(prefixSum-k, 0);
//             count.put(prefixSum, count.getOrDefault(prefixSum, 0)+1);
//         }
//         return answer;
        
        
//         int i=0, j=0, max=0, sum=0, count=0;
//         if(nums.length == 1 && nums[0] != k) return count; 
        
//         while(j<nums.length) {
//             sum += nums[j];
//             //if(sum==k) count++;
            
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
//                 // sum = 0;
//                 // i++;
//             }
            
//             j++;
//         }
//         return count;
    }
}