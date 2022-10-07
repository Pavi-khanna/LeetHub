class MovingAverage {
    // Deque<Integer> q;
    int[] q;
    int size;
    int index=0,count=0;
    double sum = 0;

    public MovingAverage(int size) {
        this.size = size;
        // q = new ArrayDeque<>();
        q = new int[size];
    }
    
    public double next(int val) {
//         if(q.size()>=size) {
//             sum -= q.remove();
//         }
//         q.add(val);
//         sum += val;
//         return sum/q.size();
        
        
    if(index >= q.length) index = 0;
    if(count < q.length) ++count;
    
    int current = q[index];
    //System.out.println(current);
    q[index] = val;
    index++;
    sum = sum - current + val;
    
    return sum/count;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */