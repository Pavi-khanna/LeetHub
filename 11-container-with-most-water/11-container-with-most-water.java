class Solution {
    public int maxArea(int[] height) {
        // n^2, 1
        // int max = 0;
        // for(int i=0; i<height.length; i++) {
        //     for(int j=i+1; j<height.length; j++) {
        //         max = Math.max(max, (j-i)*(Math.min(height[i],height[j])));
        //     }
        // }
        // return max;
        
        
        // n, 1
        int max=0, l=0, r=height.length-1;
        while(l<r) {
            int curr = Math.min(height[l],height[r])*(r-l);
            max = Math.max(max, curr);
            
            if(height[l]<height[r]) l++;
            else r--;
        }
        return max;
    }
}