class Solution {
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
    
    public List<List<Integer>> subsets(int[] nums) {
        // n*2^n, n
        return printAllSubSequences(0, new ArrayList<>(), nums, new ArrayList<>());
    }
}