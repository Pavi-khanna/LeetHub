class Solution {
    public int longestOnes(int[] nums, int k) {
//         int longestSequence = 0;
//         for (int left = 0; left < nums.length; left++) {
//             int numZeroes = 0;

//             // check every consecutive sequence
//             for (int right = left; right < nums.length; right++) {
//                 // count how many 0's
//                 if (nums[right] == 0) {
//                     numZeroes += 1;
//                 }
//                 if(numZeroes>k) break;
//                 // # update answer if it's valid
//                 if (numZeroes <= k) {
//                     longestSequence = Math.max(longestSequence, right - left + 1);
//                 }
//             }
//         }
//         return longestSequence;
        
        
        int i = 0, j = 0;
        int numZeroes = 0, max = 0;
        
        if(nums.length<1) return -1;
        
        while(j < nums.length) {
            if(nums[j]==0) numZeroes++;
            
            if(numZeroes > k) {
                if(nums[i]==0) numZeroes--;
                i++;
            } else if(numZeroes <=k) {
                max = Math.max(max, j-i+1);
            }
            j++;
        }
        return max;
    }
}