class Solution {
    public int[] nextGreaterElements(int[] arr) {
//         Stack<Integer> stack = new Stack<>();
//         int n = nums.length;
//         int[] nge = new int[n];
        
//         for(int i=(2*n-1);i>=0; i--) {
//             while(!stack.isEmpty() && stack.peek() <= nums[i%n]) stack.pop();
            
//             if(i<n) {
//                 if(!stack.isEmpty()) nge[i] = stack.peek(); 
//                 else nge[i] = -1;
//             }
//             stack.push(nums[i%n]);
//         }
//         return nge;
        
        int n = arr.length, p = 0;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=2*n-1; i>=0; i--) {
            if(stack.isEmpty()) {
                res[p%n] = -1;
            } else if(!stack.isEmpty() && stack.peek() > arr[i%n]) {
                res[p%n] = stack.peek();
            } else if(!stack.isEmpty() && stack.peek() <= arr[i%n]) {
                while(stack.size()>0 && stack.peek() <= arr[i%n]) {
                    stack.pop();
                }
                if(stack.isEmpty()) res[p%n] = -1;
                else res[p%n] = stack.peek();
            }
            p++;
            stack.push(arr[i%n]);
        }
        // reverse
        int i=0, j=n-1;
        while(i<=j) {
            int temp = res[i];
            res[i++] = res[j];
            res[j--] = temp;
        }
        return res;
    }
}