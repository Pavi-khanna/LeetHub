class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] res = new int[n];
        int[] ans = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int p = 0, k = 0;
        
        
        // for(int i=0; i<nums2.length; i++) {
        //     for(int j=i+1; j<nums2.length; j++) {
        //         if(nums2[j] > nums2[i]) {
        //             res[p++] = nums2[j];
        //             break;
        //         } else if(j == n-1) {
        //             res[p++] = -1;
        //         }
        //     }
        // }
        // res[n-1] = -1;
        
        
        for(int i=n-1; i>=0; i--) {
            if(stack.isEmpty()) {
                res[p++] = -1;
            } else if(!stack.isEmpty() && stack.peek() > nums2[i]) {
                res[p++] = stack.peek();
            } else if(!stack.isEmpty() && stack.peek() <= nums2[i]) {
                while(stack.size()>0 && stack.peek() <= nums2[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) res[p++] = -1;
                else res[p++] = stack.peek();
            }
            
            stack.push(nums2[i]);
            map.put(nums2[i], i);
        }
        // reverse
        int i=0, j=n-1;
        while(i<=j) {
            int temp = res[i];
            res[i++] = res[j];
            res[j--] = temp;
        }
        
        for(i=0; i<nums1.length; i++) {
            
            // int j = findIndex(nums2, nums1[i]);
            
            j = map.get(nums1[i]);
            if(nums1[i] == nums2[j]) {
                ans[i] = res[j];
            }
        }
        return ans;
    }
    
    // or a hashmap
    public int findIndex(int[] nums, int ele) {
        for(int i=0; i<nums.length; i++) {
            if(ele == nums[i]) return i;
        }
        return -1;
    }
}