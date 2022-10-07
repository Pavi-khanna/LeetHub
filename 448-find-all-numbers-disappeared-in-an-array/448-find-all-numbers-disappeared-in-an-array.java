class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
//         int i=0;
//         while(i<nums.length) {
//             int correct = nums[i]-1;
//             if(nums[i]!=nums[correct]) {
//                 swap(nums, i, correct);
//             } else 
//                 i++;
//         }
        
//         List<Integer> ans = new ArrayList<>();
//         for(int j=0;j<nums.length;j++) {
//             if(nums[j]!=j+1) {
//                 ans.add(j+1);
//             }
//         }
//         return ans;
        
        
//         List<Integer> list = new ArrayList<>();
//         int[] map = new int[nums.length+1];
        
//         for(int num : nums) map[num]++;
//         for(int i=1; i<map.length; i++) {
//             // System.out.println(Arrays.toString(map));
//             if(map[i]==0) list.add(i);
//         }
//         return list;
        
        
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], true);
        }
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=nums.length; i++) {
            if(!map.containsKey(i)) list.add(i);
        }
        return list;
    }
    
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}