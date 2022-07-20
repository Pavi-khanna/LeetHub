class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        // int[] res = new int[nums.length];
        // for(int i=0; i<nums.length; i++) {
        //     int count=0;
        //     for(int j=0; j<nums.length; j++) {
        //         if(i!=j && nums[j]<nums[i]) count++;
        //     }
        //     res[i] = count;
        // }
        // return res;
        
        
        Map<Integer, Integer> map = new HashMap<>();
        int[] clone = nums.clone(); // deep copy
        Arrays.sort(clone);
        
        for(int i=0; i<nums.length; i++) {
            map.putIfAbsent(clone[i], i);
        }
        
        for(int i=0; i<nums.length; i++) {
            clone[i] = map.get(nums[i]);
        }
        return clone;
    }
}