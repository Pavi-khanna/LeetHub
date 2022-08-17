class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // n^2, 1
        // Set<Integer> ans = new HashSet<Integer>();
        // int majority=nums.length/3;
        // for(int num:nums) {
        //     int count = 0;
        //     for(int elem : nums) {
        //         if(elem == num) count+=1;
        //         if(count>majority) ans.add(num);
        //     }
        // }
        // return new ArrayList<>(ans);
        
        
        // n, n
        // Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        // Set<Integer> ans = new HashSet<Integer>();
        // for(int num : nums){
        //     map.put(num,map.getOrDefault(num,0)+1);
        //     if(map.get(num)>nums.length/3){
        //         ans.add(num);
        //     }
        // }
        // return new ArrayList<>(ans);
        
        
        // n, 1
        int number1 = -1, number2 = -1, count1 = 0, count2 = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == number1)
                count1++;
            else if (nums[i] == number2)
                count2++;
            else if (count1 == 0) {
                number1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                number2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == number1) count1++;
            else if (nums[i] == number2) count2++;
        }
        if (count1 > len / 3) ans.add(number1);
        if (count2 > len / 3) ans.add(number2);
        return ans;
    }
}