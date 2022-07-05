class Solution {
    public int findKthLargest(int[] nums, int k) {
        // nlogn, 1
        Arrays.sort(nums);
        return nums[nums.length-k];
        
        
        // nlogk, k
//         PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
//         List<Integer> list = new ArrayList<>();
        
//         // keep k largest elements in the heap
//         for (int n: nums) {
//           heap.add(n);
//           if (heap.size() > k) heap.poll(); 
//         }
//         return heap.peek();
    }
}