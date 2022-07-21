class Solution {
    public int arraySign(int[] nums) {
        // int counter = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == 0) {
        //         return 0;
        //     }
        //     if (nums[i] < 0) {
        //         counter++;
        //     }
        // }
        // return counter % 2 == 0 ? 1 : -1;
    
        
        int sign = 1;
        for (int i : nums) {
            if (i == 0) return 0;
            if (i < 0) sign *= -1;
        }
        return sign;
    }
}