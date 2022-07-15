class Solution {
    public boolean canPartition(int[] nums) {
        // return canPartition(0, nums, 0, 0);
        
        // int totalSum = 0;
        // for(int num : nums) totalSum += num;
        // if(totalSum % 2 != 0) 
        //     return false;
        // else
        //     return canPartition(nums, nums.length, totalSum/2);
        
        
        int totalSum = 0;
        for(int num : nums) totalSum += num;
        Boolean[][] t = new Boolean[nums.length+1][(totalSum/2)+1];
        for(int i=0; i<nums.length+1; i++) {
            Arrays.fill(t[i], null);
        }
        if(totalSum % 2 != 0) 
            return false;
        else
            return canPartition(t, nums, nums.length, totalSum/2);
        
        
        // 2^n, n
        // int totalSum = 0;
        // for(int num : nums) totalSum += num;
        // boolean[][] t = new boolean[nums.length+1][(totalSum/2)+1];
        // if(totalSum % 2 != 0) 
        //     return false;
        // else
        //     // return sum(nums, nums.length, totalSum / 2, 0, 0, new ArrayList<>(), new ArrayList<>());
        //     return sum(t, nums);
    }
    
    public boolean canPartition(int[] arr, int n, int sum) {
         // if(n==0 && sum!=0) return false;
         // if(n==0) return true;
        
        if(n==0) {
             if(sum!=0) return false;
             else return true;
         }
         
         if(arr[n-1] > sum) {
             return canPartition(arr, n-1, sum);
         } else {
             return canPartition(arr, n-1, sum-arr[n-1]) || canPartition(arr, n-1, sum);
         }
    }
    
    public boolean canPartition(Boolean[][] t, int[] arr, int n, int sum) {
         // if(n==0 && sum!=0) return false;
         // if(n==0) return true;
        
        if(n==0) {
             if(sum!=0) return false;
             else return true;
         }
         
         if(t[n][sum] != null) return t[n][sum];
         
         if(arr[n-1] > sum) {
             return t[n][sum] = canPartition(t, arr, n-1,sum);
         } else {
             return t[n][sum] = canPartition(t, arr, n-1,sum-arr[n-1]) || 
             canPartition(t, arr, n-1,sum);
         }
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