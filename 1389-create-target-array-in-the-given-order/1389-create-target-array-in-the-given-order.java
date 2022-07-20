class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] res = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            for(int j=res.length-1; j>index[i]; j--) {
                res[j]=res[j-1];
            }
            res[index[i]]=nums[i];
        }
        return res;
    }
}