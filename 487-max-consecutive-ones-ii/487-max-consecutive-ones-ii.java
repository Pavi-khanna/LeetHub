class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // n^2, 1
        // int longestSequence = 0;
        // for (int left = 0; left < nums.length; left++) {
        //     int numZeroes = 0;
        //     // check every consecutive sequence
        //     for (int right = left; right < nums.length; right++) {
        //         // count how many 0's
        //         if (nums[right] == 0) {
        //             numZeroes += 1;
        //         }
        //         if(numZeroes>1) break; // pruning
        //         // # update answer if it's valid
        //         // if it has only 1s or just one 0
        //         if (numZeroes <= 1) {
        //             longestSequence = Math.max(longestSequence, right - left + 1);
        //         }
        //     }
        // }
        // return longestSequence;
        
        
        
        int i = 0, j = 0;
        int numZeroes = 0, max = 0;
        
        if(nums.length<1) return -1;
        
        while(j < nums.length) {
            if(nums[j]==0) numZeroes++;
            
            if(numZeroes > 1) {
                // max = Math.max(max, sum);
                // sum -= arr.get(i);
                if(nums[i]==0) numZeroes--;
                i++;
            } else if(numZeroes <=1) {
                max = Math.max(max, j-i+1);
            }
            j++;
        }
        return max;
    }
}