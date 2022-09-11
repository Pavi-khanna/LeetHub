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
        return kthSmallest(nums, 0, nums.length-1, nums.length-k+1);
    }
    
    public int kthSmallest(int[] arr, int low, int high, int k) {
        int partition = partition(arr, low, high);
        // System.out.println(partition);
        if(partition == k-1) return arr[partition];
        else if (partition < k - 1)
            return kthSmallest(arr, partition + 1, high, k);
        else
            return kthSmallest(arr, low, partition - 1, k);
    }
    
    // Quick sort
    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i=low-1;
        
        for(int j=low; j<high; j++) {
            if(pivot > arr[j]) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }
    
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}