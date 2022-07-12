class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 2^t*k(len of a ds), 
        Arrays.sort(candidates);
        return findComb(0, candidates, target, new ArrayList<>(), new ArrayList<>());
    }
    
    private List<List<Integer>> findComb(int index, int[] c, int target, List<List<Integer>> ans, List<Integer> ds) {
        if(index == c.length) {
            if(target==0) {
                ans.add(new ArrayList<>(ds));
            }
            return ans;
        }
        
        if(c[index] <= target) {
            ds.add(c[index]);
            findComb(index, c, target-c[index], ans, ds);
            ds.remove(ds.size()-1);
        }
        findComb(index+1, c, target, ans, ds);
        
        return ans;
    }
}