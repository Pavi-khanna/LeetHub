class NumArray {
    // n, 1
    // private int[] data;
    // 1, n^2
    // private Map<Pair<Integer,Integer>, Integer> map = new HashMap<>();
    // 1, n
    private int[] sum;

    public NumArray(int[] nums) {
        // 1
        // data = nums;
        
        // 2
        // for(int i=0; i<nums.length; i++) {
        //     int sum = 0;
        //     for(int j=i; j<nums.length; j++) {
        //         sum+=nums[j];
        //         map.put(new Pair<Integer,Integer>(i,j), sum);
        //     }
        // }
        
        // 3
        sum = new int[nums.length+1];
        for(int i=0;i<nums.length; i++) {
            sum[i+1] = sum[i]+nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        // 1
        // int sum = 0;
        // for(int i=left; i<=right; i++) {
        //     sum += data[i];
        // }
        // return sum;
        
        // 2
        // return map.get(new Pair<Integer,Integer>(left,right));
        
        // 3
        return sum[right+1]-sum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */