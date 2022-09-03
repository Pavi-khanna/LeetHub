class Solution {
    public int[] productExceptSelf(int[] nums) {
//         int length = nums.length;
//         int[] L = new int[length], R = new int[length], answer = new int[length];

//         L[0] = 1;
//         for (int i = 1; i < length; i++) {
//             L[i] = nums[i - 1] * L[i - 1];
//         }
//         R[length - 1] = 1;
//         for (int i = length - 2; i >= 0; i--) {
//             R[i] = nums[i + 1] * R[i + 1];
//         }
//         for (int i = 0; i < length; i++) {
//             answer[i] = L[i] * R[i];
//         }
//         return answer;
        
        
        int length = nums.length;
        int[] answer = new int[length];
        
        answer[0] = 1;
        for(int i=1; i<nums.length; i++) {
            answer[i] = answer[i-1]*nums[i-1];
        }
        int right = 1;
        for(int i=length-1; i>=0; i--) {
            answer[i] = answer[i]*right;
            right *= nums[i];
        }
        return answer;
    }
}