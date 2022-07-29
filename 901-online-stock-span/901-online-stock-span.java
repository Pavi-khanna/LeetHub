class StockSpanner {
    // List<Integer> l;
    
    Stack<int[]> stack;
    int counter = 0;

    public StockSpanner() {
        // l=new ArrayList<>();
        stack = new Stack<>();
    }
    
    public int next(int price) {
        // l.add(price);
        // int ans=0;
        // for(int i=l.size()-1;i>=0;i--){
        //     if(l.get(i)<=price)
        //         ans++;
        //     else
        //         break;
        // }
        // return ans;
        
            int res = 1, n = stack.size();
            if(stack.isEmpty()) {
                res = 1+counter;  // 1 more than i means it has reached beyond 0
            } else if(!stack.isEmpty() && stack.peek()[1] > price) {
                res = counter-stack.peek()[0];    // current index - greatest element to left index
            } else if(!stack.isEmpty() && stack.peek()[1] <= price) {
                while(stack.size()>0 && stack.peek()[1] <= price) {
                    stack.pop();
                }
                if(stack.isEmpty()) res = 1+counter;
                else res = counter-stack.peek()[0];
            }
            stack.push(new int[]{counter, price});
            counter++;
            return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */