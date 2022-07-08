class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int top;
    
    // private Queue queue;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        
        // queue = new LinkedList<>();
    }
    
    public void push(int x) {
        // q1.add(x);
        // top = x;
        
        
        q2.add(x);
        top = x;
        while(!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        
        
        // Queue q = new LinkedList<>();
        // q.add(x);
        // q.add(queue);
        // queue = q;
        // System.out.println(queue);
    }
    
    public int pop() {
        // while(q1.size()>1) {
        //     top = q1.remove();
        //     q2.add(top);
        // }
        // int popped = q1.remove();
        // Queue<Integer> temp = q1;
        // q1 = q2;
        // q2 = temp;
        // return popped;
        
        
        int popped = q1.remove();
        if(!q1.isEmpty()) {
            top = q1.peek();
        }
        return popped;
        
        
        // int a = (int) queue.remove();
        // queue = (Queue) queue.peek();
        // System.out.println(queue);
        // return (int) a;
    }
    
    public int top() {
        return top;
        
        
        // return (int) queue.peek();
    }
    
    public boolean empty() {
        return q1.size()==0;
        
        
        // return queue == null;
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