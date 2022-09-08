class Solution {
    public boolean canJump(int[] nums) {
        // return canJumpFromPosition(0, nums);
        
        
        int n = nums.length;
        Boolean[] t = new Boolean[n];
        return canJumpFromPosition(0, nums, n, t);
        
        
        // int reach = 0;
        // for(int i = 0; i<= reach; i++){
        //     reach = Math.max(reach, i+nums[i]);
        //     if(reach >= nums.length-1){
        //         return true;
        //     }
        // }
        // return false;
    }
    
    public boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean canJumpFromPosition(int position, int[] nums, int n, Boolean[] t) {
        if (position == n - 1) {
            return true;
        }

        if(t[position] != null) return t[position];
        
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums, n, t)) {
                return t[position]=true;
            }
        }
        return t[position]=false;
    }
}