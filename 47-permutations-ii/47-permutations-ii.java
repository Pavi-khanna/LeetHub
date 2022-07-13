class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        recurPermute(0, nums, ans);
        List<List<Integer>> list = new ArrayList<>();
        for(List<Integer> num : ans) {
            list.add(new ArrayList<>(num));
        }
        return list;
    }
    
    private void recurPermute(int index, int[] nums, Set<List<Integer>> ans) {
        if(index == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for(int num : nums) {
                ds.add(num);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=index; i<nums.length; i++) {
            if(i>index && nums[i]==nums[i-1]) continue;
            
            swap(index, i, nums);
            recurPermute(index+1, nums, ans);
            swap(index, i, nums);
        }
    }
    
    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}