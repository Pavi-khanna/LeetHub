class Solution {
    public int numIdenticalPairs(int[] nums) {
        // int count=0;
        // for(int i=0; i<nums.length; i++) {
        //     for(int j=0; j<nums.length; j++) {
        //         if(i<j && nums[i]==nums[j]) count++;
        //     }
        // }
        // return count;
        
        
        // handshake problem
        HashMap<Integer, Integer> map = new HashMap<>();
        int count=0;
        
        for(int i=0; i<nums.length; i++) {
            int current = map.getOrDefault(nums[i], 0);
            count+=current;
            map.put(nums[i], current+1);
        }
        return count;
    }
}