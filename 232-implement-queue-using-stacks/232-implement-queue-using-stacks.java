class MyQueue {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    int front;

    public MyQueue() {
        
    }
    
    public void push(int x) {
        // if(s1.empty()) front = x;          // only when stack is empty
        // while(!s1.isEmpty()) s2.push(s1.pop());
        // s2.push(x);
        // while(!s2.isEmpty()) s1.push(s2.pop());
        
        
        if(s1.isEmpty()) front = x;
        s1.push(x);
    }
    
    public int pop() {
        // int num = s1.pop();
        // if(!s1.isEmpty()) {
        //     front = s1.peek();
        // }
        // return num;
        
        
        if(s2.isEmpty()) {
            while(!s1.isEmpty()) s2.push(s1.pop());
        }
        return s2.pop();
    }
    
    public int peek() {
        // return front;
        
        
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }
    
    public boolean empty() {
        // return s1.isEmpty();
        
        
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */