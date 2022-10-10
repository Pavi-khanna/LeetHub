class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 2^n*mlogm (m = 2^n) => n*2^2n, 
        Arrays.sort(nums);
        Set<List<Integer>> set = printAllSubSequences(0, new ArrayList<>(), nums, new HashSet<>());
        return new ArrayList<>(set);
        // return printAllSubSequences(0, new ArrayList<>(), nums, new ArrayList<>());

        
        // n*2^n, n
        // Arrays.sort(nums);
        // List<List<Integer>> ans = new ArrayList<>();
        // findSubsets(0, nums, new ArrayList<>(), ans);
        // return ans;
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
    
    public List<List<Integer>> printAllSubSequences(int i, List<Integer> prevSubSet, int[] nums, List<List<Integer>> res) {
        if(i==nums.length){
            res.add(new ArrayList<>(prevSubSet));
            return res;
        }
        
        // take it 1 time and then skip the next time
        prevSubSet.add(nums[i]);
        printAllSubSequences(i+1, prevSubSet, nums, res);
        
        while(i+1<nums.length && nums[i+1]==nums[i]) ++i;
        prevSubSet.remove(prevSubSet.size()-1);
        printAllSubSequences(i+1, prevSubSet, nums, res);
        
        return res;
    }
}