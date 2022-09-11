class Solution {
    public int singleNumber(int[] nums) {
        // Arrays.sort(nums);
        // int num = 0;
        // for(int i=0; i<nums.length-1; i++) {
        //     if(nums[i]==nums[i+1]) i+=2;
        //     else return nums[i];
        // }
        // return nums[nums.length-1];
        
        
        // Map<Integer, Integer> map = new HashMap<>();
        // for(int num : nums) {
        //     map.put(num, map.getOrDefault(num,0)+1);
        // }
        // for(int num : nums) {
        //     if(map.get(num) == 1) return num;
        // }
        // return 0;
        
        
        // long setSum = 0, arraySum = 0;
        // Set<Integer> set = new HashSet<>();
        // for(int num : nums) {
        //     if(!set.contains(num)) {
        //         set.add(num);
        //         setSum += num;
        //     }
        //     arraySum += num;
        // }
        // return (int)((3*(setSum) - arraySum) /2);
        
        
        int res = 0;
        for(int i = 0; i < 32; i++) {
            int cur = 0;
            for(int num: nums) {
                cur+= (num >> i) & 1;
            }
            cur %= 3;
            res = res | (cur << i);
        }
        return res;
    }
}