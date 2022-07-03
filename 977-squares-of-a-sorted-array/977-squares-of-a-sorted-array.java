class Solution {
    public int[] sortedSquares(int[] nums) {
        // nlogn, logn
        // int[] arr = new int[nums.length];
        // for(int i=0; i<nums.length; i++) {
        //     arr[i] = nums[i]*nums[i];
        // }
        // Arrays.sort(arr);
        // return arr;
        
        // n, n
        int n=nums.length, left=0, right=n-1;
        int[] res = new int[n];
        
        for(int i=n-1; i>=0; i--) {
            int square;
            if(Math.abs(nums[left]) < Math.abs(nums[right])) {
                square = nums[right];
                right--;
            } else {
                square = nums[left];
                left++;
            }
            res[i] = square*square;
        }
        return res;
    }
}