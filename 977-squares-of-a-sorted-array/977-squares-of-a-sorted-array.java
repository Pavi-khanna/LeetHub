class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            arr[i] = nums[i]*nums[i];
        }
        Arrays.sort(arr);
        return arr;
        
//         int n = nums.length;
//         int[] result = new int[n];
//         int left = 0;
//         int right = n-1;
        
//         for(int i = n-1; i>=0; i--) {
//             int square;
//             if(Math.abs(nums[left]) < Math.abs(nums[right])) {
//                 square = nums[right];
//                 right--;
//             } else {
//                 square = nums[left];
//                 left++;
//             }
//             result[i] = square*square;
//         }
//         return result;
    }
}