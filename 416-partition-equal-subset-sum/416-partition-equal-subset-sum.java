class Solution {
    public boolean canPartition(int[] nums) {
        // return canPartition(0, nums, 0, 0);
        
        // 2^n, n
        int totalSum = 0;
        for(int num : nums) totalSum += num;
        boolean[][] t = new boolean[nums.length+1][(totalSum/2)+1];
        if(totalSum % 2 != 0) 
            return false;
        else
            // return sum(nums, nums.length, totalSum / 2, 0, 0, new ArrayList<>(), new ArrayList<>());
            return sum(t, nums);
    }
    
    public boolean sum(boolean[][] t,int arr[]) {
        int rows = t.length, cols = t[0].length;
        for(int j=0; j<cols; j++) t[0][j] = false;
        for(int i=0; i<rows; i++) t[i][0] = true;
         
         for(int i=1; i<rows; i++) {
             for(int j=1; j<cols; j++) {
                 if(arr[i-1] > j) {
                    t[i][j] = t[i-1][j];
                 } else {
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                 }
             }
         }
         return t[rows-1][cols-1];
    }
    
    public boolean sum(int arr[], int n, int sum, int i, int s, List<Integer> ds, List<List<Integer>> ans){
        if(i == n) {
           if(s == sum) {
               // System.out.println(ds);
               ans.add(new ArrayList<>(ds));
               return true;
           }
           else return false;
        }
        
        ds.add(arr[i]);
        s+=arr[i];
        if(sum(arr,n,sum,i+1,s,ds,ans)) return true;
        ds.remove(ds.size()-1);
        s-=arr[i];
        
        if(sum(arr,n,sum,i+1,s,ds,ans)) return true;
        
        return false;
    }
    
    public boolean canPartition(int i, int[] nums, int sum1, int sum2) {
        if(i==nums.length) return sum1==sum2;
        return canPartition(i+1, nums, sum1+nums[i], sum2) || canPartition(i+1, nums, sum1, sum2+nums[i]);
    }
}