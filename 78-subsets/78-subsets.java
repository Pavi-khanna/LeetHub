class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // n*2^n, n
        return printAllSubSequences(0, new ArrayList<>(), nums, new ArrayList<>());
        
        // List<List<Integer>> ans = new ArrayList<>();
        // findSubsets(0, nums, new ArrayList<>(), ans);
        // return ans;
    }
    
    public List<List<Integer>> printAllSubSequences(int i, List<Integer> prevSubSet, int[] nums, List<List<Integer>> res) {
        if(i==nums.length){
            res.add(new ArrayList<>(prevSubSet));
            return res;
        }
        
        prevSubSet.add(nums[i]);
        printAllSubSequences(i+1, prevSubSet, nums, res);
        prevSubSet.remove(prevSubSet.size()-1);
        printAllSubSequences(i+1, prevSubSet, nums, res);
        
        return res;
    }
    
    private void findSubsets(int index, int[] nums, List<Integer> ds, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(ds));
        for(int i=index; i<nums.length;i++) {
            ds.add(nums[i]);
            findSubsets(i+1, nums, ds, ans);
            ds.remove(ds.size()-1);
        }
    }
}