class MedianFinder {
    // List<Integer> list;
    
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {
        // list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        // 1
        // list.add(num);
        
        // n+logn
        // int idx = Collections.binarySearch(list, num);
        // if(idx>=0) list.add(idx, num);
        // else list.add(-idx-1, num);
        
        // 5*logn
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if(minHeap.size()>maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        // nlogn
        // Collections.sort(list);
        // int n = list.size();
        // return (n%2!=0 ? list.get(n/2) : ((double) list.get(n/2-1) +list.get(n/2))*0.5);
        
        // 1
        // int n = list.size();
        // return (n%2!=0 ? list.get(n/2) : ((double) list.get(n/2-1) +list.get(n/2))*0.5);
        
        // 1
        return minHeap.size()!=maxHeap.size() ? maxHeap.peek() : 
                        ((double) minHeap.peek() + maxHeap.peek())*0.5;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */