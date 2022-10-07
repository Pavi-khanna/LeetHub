class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> intersection = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int i=0, j=0; i<nums1.length && j<nums2.length; ) {
            if(nums1[i]<nums2[j]) i++;
            else if(nums1[i]>nums2[j]) j++;
            else { intersection.add(nums1[i]); i++; j++; }
        }
        return intersection.stream()
                           .mapToInt(Integer::intValue)
                           .toArray();
    }
}