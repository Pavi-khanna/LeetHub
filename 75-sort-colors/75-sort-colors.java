class Solution {
    public void sortColors(int[] nums) {
        // nlogn, 1
        // Arrays.sort(nums);
        
        
        // 2n, 1
        int c0=0, c1=0, c2=0, k=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==0) c0++;
            if(nums[i]==1) c1++;
            if(nums[i]==2) c2++;
        }
        while(k<c0) nums[k++] = 0;
        while(k<c0+c1) nums[k++] = 1;
        while(k<c0+c1+c2) nums[k++] = 2;
        
        
        // n, 1
//         int low=0, mid=0, high=nums.length-1, temp;
        
//         while(mid<=high) {
//             switch(nums[mid]) {
//                 case 0:
//                     temp = nums[low];
//                     nums[low++] = nums[mid];
//                     nums[mid++] = temp;
//                     break;
//                 case 1:
//                     mid++;
//                     break;
//                 case 2:
//                     temp = nums[mid];
//                     nums[mid] = nums[high];
//                     nums[high--] = temp;
//                     break;
//             }
//         }
    }
}