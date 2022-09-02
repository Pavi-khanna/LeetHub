class Solution {
    public int maxProduct(int[] A) {
        
        // int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, sum = 1, begin = 0, end = 0, start = 0;
        // for(int i=0; i<nums.length;i++) {
        //     sum *= nums[i];
        //     if(max<sum) {
        //         max = Math.max(sum, nums[i]);
        //         start = begin;
        //         end = i;
        //     }
        //     // if(sum<0) {
        //     //     sum = 1;
        //     //     begin = i+1;
        //     // }
        // }
        // // System.out.println(Arrays.toString(Arrays.copyOfRange(nums, start, end+1)));
        // return max;
        
        
        // n^2, 1
//         if (nums.length == 0) return 0;
//         int result = nums[0];
//         for (int i = 0; i < nums.length; i++) {
//             int accu = 1;
//             for (int j = i; j < nums.length; j++) {
//                 accu *= nums[j];
//                 result = Math.max(result, accu);
//             }
//         }
//         return result;
        
        
        // n, 1
        if (A.length == 0) return 0;
        int max = A[0], min = A[0], result = A[0], end=0,start=0;
        for (int i = 1; i < A.length; i++) {
            int temp = max;
            
            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
            
            
            if (max > result) {
                result = max;
                end = i;
                // System.out.println(A[i]+" "+start+" "+end+" "+result);
            }
        }
        return result;
    }
}