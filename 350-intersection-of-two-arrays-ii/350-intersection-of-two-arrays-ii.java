class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // List<Integer> intersection = new ArrayList<>();
        // Arrays.sort(nums1);
        // Arrays.sort(nums2);
        // for(int i=0, j=0; i<nums1.length && j<nums2.length; ) {
        //     if(nums1[i]<nums2[j]) i++;
        //     else if(nums1[i]>nums2[j]) j++;
        //     else { intersection.add(nums1[i]); i++; j++; }
        // }
        // return intersection.stream()
        //                    .mapToInt(Integer::intValue)
        //                    .toArray();
        
        
        List<Integer> set = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
    }
    
    public boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}