class MinStack {
    private Stack<Integer> s = new Stack<>();
    private Stack<Integer> ss = new Stack<>();
    
    // private Stack<int[]> stack = new Stack<>();
    
    public MinStack() {}
    
    public void push(int val) {
        s.push(val);
        if(ss.size() == 0 || ss.peek() >= val) ss.push(val);
        
        
        // int min = stack.isEmpty() ? val : Math.min(val,getMin());
        // stack.push(new int[]{val,min});
    }
    
    public void pop() {
        // if(s.isEmpty()) return -1;
        int ans = s.pop();
        if(ans == ss.peek()) {
            ss.pop();
        }
        
        
        // stack.pop();
    }
    
    public int top() {
        return s.peek();
        
        
        // return stack.peek()[0];
    }
    
    public int getMin() {
        return ss.isEmpty() ? -1 : ss.peek();
        
        
        // return stack.peek()[1];
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