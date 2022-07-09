class Solution {
    public int[] nextGreaterElements(int[] arr) {
        // n^2, 1
//         int n = arr.length, p = 0;
//         int[] res = new int[n];

//         for(int i=0; i<arr.length; i++) {
//             for(int j=i+1; j<2*arr.length; j++) {
//                 int index = j%n;
//                 if(arr[index] > arr[i]) {
//                     res[p++] = arr[index];
//                     break;
//                 } else if(j == 2*n-1) {
//                     res[p++] = -1;
//                 }
//             }
//         }
//         return res;
        
        
        // n, n
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