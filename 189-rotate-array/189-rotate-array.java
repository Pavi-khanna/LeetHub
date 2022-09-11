class Solution {
    public void rotate(int[] nums, int k) {
        // k*n, 1
        // k%=nums.length;
        // for(int i=0; i<k; i++) {
        //     rotateByOne(nums);
        // }
        
        
        int n = nums.length;
        int[] temp = new int[n];
        for(int i=0; i<n; i++) temp[(i+k)%n] = nums[i];
        for(int i=0; i<n; i++) nums[i]=temp[i];
    }
    
    public void rotateByOne(int[] a) {
        int lastNum = a[a.length-1];
        for(int i=a.length-1; i>=1; i--) {
            a[i] = a[i-1];
        }
        a[0]=lastNum;
    }
}