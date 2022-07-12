class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 2^n*klogn
        // Arrays.sort(candidates);
        // Set<List<Integer>> set = findComb(0, candidates, target, new HashSet<>(), new ArrayList<>());
        // return new ArrayList<>(set);
        
        // 2^n*k, k*x
        Arrays.sort(candidates);
        return findComb(0, candidates, target, new ArrayList<>(), new ArrayList<>());
    }
    
    private Set<List<Integer>> findComb(int index, int[] c, int target, HashSet<List<Integer>> ans, List<Integer> ds) {
        if(index == c.length) {
            if(target==0) {
                ans.add(new ArrayList<>(ds));
            }
            return ans;
        }
        
        if(c[index] <= target) {
            ds.add(c[index]);
            findComb(index+1, c, target-c[index], ans, ds);
            ds.remove(ds.size()-1);
        }
        findComb(index+1, c, target, ans, ds);
        
        return ans;
    }
    
    private List<List<Integer>> findComb(int index, int[] c, int target, List<List<Integer>> ans, List<Integer> ds) {
        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return ans;
        }
        
        for(int i=index;i<c.length;i++) {
            if(i!=index && c[i]==c[i-1]) continue;   // 1st index ko ignore na krde cz i==index
            if(c[i]>target) break;     // anything on the right of the sorted arr is >
            
            ds.add(c[i]);
            findComb(i+1, c, target-c[i], ans, ds);
            ds.remove(ds.size()-1);
        }
        return ans;
    }
}