class MovingAverage {
    Deque<Integer> q;
    int size;
    double sum = 0;

    public MovingAverage(int size) {
        this.size = size;
        q = new ArrayDeque<>();
    }
    
    public double next(int val) {
        if(q.size()>=size) {
            sum -= q.remove();
        }
        
        q.add(val);
        sum += val;
        return sum/q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */