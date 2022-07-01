class MinStack {
    Stack<Integer> s;
    Stack<Integer> ss;

    public MinStack() {
        s = new Stack<>();
        ss = new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
        if(ss.size()==0 || val <= ss.peek()) {  // = to handle duplicates
            ss.push(val);
        }
    }
    
    public void pop() {
        if(s.size()>0 && ss.size()>0) {
         int ans = s.pop();
         if(ans == ss.peek()) ss.pop();
        }
    }
    
    public int top() {
        if(s.size()==0) return -1;
        return s.peek();
    }
    
    public int getMin() {
        if(ss.size()==0) return 0;
        return ss.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */