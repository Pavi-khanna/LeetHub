class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Set<Integer> intersection = new HashSet<>();
        // for(int i=0; i<nums1.length; i++) {
        //     for(int j=0; j<nums2.length; j++) {
        //         if(nums1[i]==nums2[j]) intersection.add(nums1[i]);
        //     }
        // }
        // return intersection.stream()
        //                    .mapToInt(Integer::intValue)
        //                    .toArray();
        
        
//         Set<Integer> set1 = new HashSet<>();
//         for(int num : nums1) set1.add(num);
//         Set<Integer> set2 = new HashSet<>();
//         for(int num : nums2) set2.add(num);
        
//         // if(set1.size()<set2.size()) return setInt(set1, set2);
//         // else return setInt(set2, set1);
        
//         set1.retainAll(set2);
        
//         int[] op = new int[set1.size()];
//         int idx=0;
//         for(int s:set1) op[idx++] = s;
//         return op;
        
        
        Set<Integer> set = new HashSet<>();
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
    
    public int[] setInt(Set<Integer> set1, Set<Integer> set2) {
        int[] op = new int[set1.size()];
        int idx = 0;
        for(int s : set1)
            if(set2.contains(s)) op[idx++] = s;
        
        return Arrays.copyOf(op, idx);
    }
}