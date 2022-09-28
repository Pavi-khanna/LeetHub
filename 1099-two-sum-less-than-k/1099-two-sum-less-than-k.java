class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int answer = -1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // if(nums[i]>=k) continue;
                int j = search(nums, i+1, nums.length-1, k-nums[i]);
                if(j != -1) {
                    int sum = nums[i] + nums[j];
                    if (sum < k) {
                        answer = Math.max(answer, sum);
                    }
                }
        }
        return answer;
    }
    
    public int search(int[] nums, int start, int end, int target) {
        int low = start, high = end, mid=0;
        while(low<=high) {
            mid = (low +(high-low)/2);
            
            if(nums[mid] == target || nums[mid]>target) high = mid-1;
            // else if(nums[mid]<target) low = mid+1;
            else low = mid+1;
        }
        return high>=start ? high : -1;
    }
}