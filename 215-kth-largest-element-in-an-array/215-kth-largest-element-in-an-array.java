class Solution {
    public int findKthLargest(int[] nums, int k) {
        // nlogn, 1
        // Arrays.sort(nums);
        // return nums[nums.length-k];
        
        
        // nlogk, k
//         PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
//         List<Integer> list = new ArrayList<>();
        
//         // keep k largest elements in the heap
//         for (int n: nums) {
//           heap.add(n);
//           if (heap.size() > k) heap.poll();
//           // System.out.println(heap);
//         }
//         return heap.peek();
        
        
        // quickselect
        return kthLargest(nums, 0, nums.length-1, nums.length-k+1);
    }
    
    public int kthLargest(int[] arr, int low, int high, int k) {
        int partition = partition(arr, low, high);
        if(partition == k-1) return arr[partition];
        else if (partition < k - 1)
            return kthLargest(arr, partition + 1, high, k);
        else
            return kthLargest(arr, low, partition - 1, k);
    }
    
    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high], pivotloc = low;
        for (int i = low; i <= high; i++) {
            // inserting elements of less value
            // to the left of the pivot location
            if (arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[pivotloc];
                arr[pivotloc] = temp;
                pivotloc++;
            }
        }
        // swapping pivot to the final pivot location
        int temp = arr[high];
        arr[high] = arr[pivotloc];
        arr[pivotloc] = temp;
  
        return pivotloc;
    }
}