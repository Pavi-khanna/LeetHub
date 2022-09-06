class MedianFinder {
    List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        // list.add(num);
        
        
        int idx = Collections.binarySearch(list, num);
        if(idx>=0) list.add(idx, num);
        else list.add(-idx-1, num);
    }
    
    public double findMedian() {
        // nlogn, n
        // Collections.sort(list);
        // int n = list.size();
        // return (n%2!=0 ? list.get(n/2) : ((double) list.get(n/2-1) +list.get(n/2))*0.5);
        
        
        int n = list.size();
        return (n%2!=0 ? list.get(n/2) : ((double) list.get(n/2-1) +list.get(n/2))*0.5);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */