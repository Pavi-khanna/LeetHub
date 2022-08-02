class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 2^n*mlogm (m = 2^n) => n*2^2n, 
        // Arrays.sort(nums);
        // Set<List<Integer>> set = printAllSubSequences(0, new ArrayList<>(), nums, new HashSet<>());
        // List<List<Integer>> list = new ArrayList<>();
        // for(List<Integer> num : set) {
        //     list.add(new ArrayList<>(num));
        // }
        // return list;
        
        
        // n*2^n, n
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), ans);
        return ans;
    }
    
    private void findSubsets(int index, int[] nums, List<Integer> ds, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(ds));
        for(int i=index; i<nums.length;i++) {
            if(i!=index && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            findSubsets(i+1, nums, ds, ans);
            ds.remove(ds.size()-1);
        }
    }
    
    private Set<List<Integer>> printAllSubSequences(int i, List<Integer> prevSubSet, int[] nums, Set<List<Integer>> res) {
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
}