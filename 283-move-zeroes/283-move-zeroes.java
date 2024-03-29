class Solution {
    public void moveZeroes(int[] nums) {
//         int snowBallSize = 0;
        
//         for(int i=0; i<nums.length; i++) { // 0 1 2 3 4
//             if(nums[i]<0) {
//                 // System.out.println(i+"a");
//                 snowBallSize++; // 1 2
//             } else if(snowBallSize > 0) {
//                 // System.out.println(i+"b"+snowBallSize);
//                 int temp = nums[i-snowBallSize];
//                 nums[i-snowBallSize] = nums[i];
//                 nums[i] = temp;
//             }
//             System.out.println(Arrays.toString(nums) +" "+ i+": "+ (i-snowBallSize)+" "+nums[i]);
//         }
        
        
        
        // n, n
        // List<Integer> list = new ArrayList<>();
        // for(int num : nums) {
        //     if(num!=0){
        //         list.add(num);
        //     }
        // }
        // int zeroes = nums.length-list.size(), i=0;
        // for(i=0; i<list.size(); i++) {
        //     nums[i] = list.get(i);
        // }
        // while(zeroes > 0) {
        //     nums[i++] = 0;
        //     zeroes--;
        // }
        
        
    // n, 1
    // int lastNonZeroFoundAt = 0;
    // for (int i = 0; i < nums.length; i++) {
    //     if (nums[i] != 0) {
    //         nums[lastNonZeroFoundAt++] = nums[i];
    //     }
    // }
    // for (int i = lastNonZeroFoundAt; i < nums.length; i++) nums[i] = 0;
        
        
        
        int n = nums.length, lastNonZeroFoundAt = 0;
        if(n==0 || n==1)  return;
        
        for(int i=0; i<n; i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt++] = temp;
            }
        }
    }
}
// 0 1 0 3 12
// 1 0 0 3 12  o O 
// 1 3 0 0 12
// 1 3 12 0 0