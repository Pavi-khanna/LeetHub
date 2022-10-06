class Solution {
    public List<String> summaryRanges(int[] nums) {
        // n, 1
        List<String> summary = new ArrayList<>();
        int i, j;
        if(nums.length == 0) return summary;
        for(i=0, j=0; j<nums.length-1; j++) {
            // if(j+1<nums.length && nums[j+1]==nums[j]+1) continue;
            if(nums[j+1]!=nums[j]+1) {
                summary.add(range(nums[i], nums[j]));
                i=j+1;
            }
            // else if(i==j) summary.add(nums[i]+"");
            // else summary.add(nums[i]+"->"+nums[j]);
            // i=j+1;
        }
        summary.add(range(nums[i], nums[j]));
        return summary;
        
        
        // List<String> res = new ArrayList<>();
        // if(nums.length == 0) return res;
        // int l=0, r;
        // for(r=1; r<nums.length; r++) {
        //     if(nums[r]!=nums[r-1]+1) {
        //         res.add(range(nums[l], nums[r-1]));
        //         l=r;
        //     }
        // }
        // res.add(range(nums[l], nums[r-1]));
        // return res;
    }
    
    private String range(int l, int r) {
        if(l == r) return ""+l;
        else return l + "->" + r;
    }
}