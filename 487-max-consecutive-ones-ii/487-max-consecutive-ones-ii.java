class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // n^2, 1
        int longestSequence = 0;
        for (int left = 0; left < nums.length; left++) {
            int numZeroes = 0;
            // check every consecutive sequence
            for (int right = left; right < nums.length; right++) {
                // count how many 0's
                if (nums[right] == 0) {
                    numZeroes += 1;
                }
                if(numZeroes>1) break;
                // # update answer if it's valid
                // if it has only 1s or just one 0
                if (numZeroes <= 1) {
                    longestSequence = Math.max(longestSequence, right - left + 1);
                }
            }
        }
        return longestSequence;
        
        
        
    }
}