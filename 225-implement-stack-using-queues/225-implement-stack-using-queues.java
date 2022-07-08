class MyStack {
    private Queue queue;

    public MyStack() {
        
    }
    
    public void push(int x) {
        Queue q = new LinkedList<>();
        q.add(x);
        q.add(queue);
        queue = q;
    }
    
    public int pop() {
        int a = (int) queue.remove();
        queue = (Queue) queue.peek();
        return (int) a;
    }
    
    public int top() {
        return (int) queue.peek();
    }
    
    public boolean empty() {
        return queue == null;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */