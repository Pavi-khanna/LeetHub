class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num:nums){
            set.add(num);
        }
        int streak = 0;
        
        for(int num:nums) {
            if(!set.contains(num-1)) {
                int curr = num;
                int currStreak = 1;
                
                while(set.contains(curr+1)) {
                    curr+=1;
                    currStreak+=1;
                }
                streak = Math.max(streak, currStreak);
            }
        }
        return streak;
    }
}