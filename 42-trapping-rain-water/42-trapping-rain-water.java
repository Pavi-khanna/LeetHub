class Solution {
    public int trap(int[] height) {
        // n^2, 1
//         int ans = 0;
        
//         for(int i=1;i<height.length; i++) {
//             int lh =0, rh=0;
//             for(int j=i; j>=0; j--) lh = Math.max(lh, height[j]);
//             for(int j=i; j<height.length;j++) rh = Math.max(rh, height[j]);
            
//             ans += Math.min(lh,rh) - height[i];
//         }
//         return ans;
        
        // n, n
//         int n = height.length;
//         int[] left = new int[n];
//         int[] right = new int[n];
//         left[0] = height[0];
//         for(int i=1; i<n; i++) {
//             left[i] = Math.max(left[i-1], height[i]);
//         }
//         right[n-1] = height[n-1];
//         for(int i=n-2; i>=0; i--) {
//             right[i] = Math.max(right[i+1], height[i]);
//         }
        
//         int[] waterLevel = new int[n];
//         int sum = 0;
//         for(int i=0; i<n; i++) {
//             waterLevel[i] = Math.min(left[i], right[i]) - height[i];
//             sum += waterLevel[i];
//         }
//         return sum;
        
        
        // n,1
        int left=0, right=height.length-1, sum =0, leftMax = 0, rightMax = 0;
        
        while(left<right) {
            if(height[left]<height[right]) {
                if(height[left]>=leftMax) leftMax = height[left];
                else sum += leftMax - height[left];
                ++left;
            } else {
                if(height[right]>=rightMax) rightMax = height[right];
                else sum += rightMax - height[right];
                --right;
            }
        }
        return sum;
    }
}