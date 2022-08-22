class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // n^3logm, m
//         Set<List<Integer>> triplets = new HashSet<>();
//         for(int i=0; i<nums.length-2; i++) {
//             for(int j=i+1; j<nums.length-1; j++) {
//                 for(int k=j+1; k<nums.length; k++) {
//                     List<Integer> triplet = new ArrayList<>();
//                     if(nums[i]+nums[j]+nums[k] == 0) {
//                         triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        
//                         Collections.sort(triplet);
//                         triplets.add(triplet);
//                     }
//                 }
//             }
//         }
//         return new ArrayList<>(triplets);
        
        
        // n^2logm, m
        // Set<List<Integer>> result = new HashSet<>();
        // Map<Integer, Integer> lookup = new HashMap<>(nums.length);
        // for (int i = 0; i < nums.length; i++) {
        //     lookup.put(nums[i], i);
        // }
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         int key = - nums[i] - nums[j];
        //         if (lookup.containsKey(key)) {
        //             int k = lookup.get(key);
        //             if (k != i && k != j) {
        //                 List<Integer> tuple = Arrays.asList(nums[i], nums[j], nums[k]);
        //                 Collections.sort(tuple);
        //                 result.add(tuple);
        //             }
        //         }
        //     }
        // }
        // return new ArrayList(result);
        
        
        // n^2, m+n
//         List<List<Integer>> result = new ArrayList<List<Integer>>();
//         Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
//         Arrays.sort(nums);
        
//         for(int i = 0; i < nums.length; i++) numsMap.put(nums[i], i);

//         for(int i = 0; i < nums.length; i++) {
//         	if(i > 0 && nums[i] == nums[i - 1]) continue;
//         	for(int j = i+1; j < nums.length; j++) {
//         		int key = 0 -(nums[i] + nums[j]);
//              if(j > i+1 && nums[j] == nums[j-1]) continue;
//         		if(numsMap.containsKey(key) && numsMap.get(key) > j) {
//         			result.add(Arrays.asList(nums[i], nums[j], key));
//         		}
//         	 }
//         }
//         return result;
        
        
        // n^2, n
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i]) {
                // twoSumBrute(nums, i, res);
                // twoSum(nums, i, res);
                twoSumII(nums, i, res);
            }
        return res;
        
        
        // n^2, n
        // Arrays.sort(nums);
        // List<List<Integer>> res = new ArrayList<>();
        // for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
        //     if (i == 0 || nums[i - 1] != nums[i]) {
        //         twoSumII(nums, i, res);
        //     }
        // return res;
        
        
         // n^2, n
        // Set<List<Integer>> res = new HashSet<>();
        // Set<Integer> dups = new HashSet<>();
        // Map<Integer, Integer> seen = new HashMap<>();
        // for (int i = 0; i < nums.length; ++i)
        //     if (dups.add(nums[i])) {   // not duplicate
        //         for (int j = i + 1; j < nums.length; ++j) {
        //             int complement = 0 -(nums[i] + nums[j]);
        //             if (seen.containsKey(complement) && seen.get(complement) == i) {
        //                 List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
        //                 Collections.sort(triplet);
        //                 res.add(triplet);
        //             }
        //             seen.put(nums[j], i);
        //         }
        //     }
        // return new ArrayList(res);
    }
    
    void twoSumBrute(int[] nums, int k, List<List<Integer>> res) {
        for (int i = k + 1; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == 0 - nums[i] -nums[k]) {
                    res.add(Arrays.asList(nums[k], nums[i], nums[j]));
                }
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) ++j;
            }
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) ++i;
        }
    }
    
    void twoSum(int[] nums, int i, List<List<Integer>> res) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int j = i + 1; j < nums.length; ++j) {
            int complement = -nums[i] - nums[j];
            if (seen.contains(complement)) {
                res.add(Arrays.asList(nums[i], nums[j], complement));
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) ++j;
            }
            seen.add(nums[j]);
        }
    }
    
    void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0) {
                ++lo;
            } else if (sum > 0) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while (lo < hi && nums[lo] == nums[lo - 1]) ++lo;
            }
        }
    }
}