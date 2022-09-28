class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // nlogn, n : n=n+m
        // for (int i = 0; i < n; i++) {
        //     nums1[i + m] = nums2[i];
        // }
        // Arrays.sort(nums1);
        
        
        // n+m, 1
        int p1 = m - 1;
        int p2 = n - 1;
        
        for (int p = nums1.length-1; p >= 0; p--) {
            if (p2 < 0) {
                break;
            }
            // jo bda h vo chipka denge p pe
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1--];
            } else {
                nums1[p] = nums2[p2--];
            }
        }
    }
}