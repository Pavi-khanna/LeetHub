class Solution {
    public int largestRectangleArea(int[] heights) {
        // n^2, 1
        // int max = 0, n = heights.length;
        // for(int i=0; i<n; i++) {
        //     int minH = Integer.MAX_VALUE;    // breath
        //     for(int j=i; j<n; j++) {
        //         minH = Math.min(minH, heights[j]);
        //         max = Math.max(max, minH*(j-i+1)); // l*b
        //     }
        // }
        // return max;
        
        
        // n, n
        int n = heights.length, max = Integer.MIN_VALUE;
        int[] left = leftSmaller(heights), right = rightSmaller(heights), area = new int[n];
        for(int i=0; i<heights.length; i++) {
            // System.out.println(left[i] +" "+right[i]);
            area[i] = heights[i] * (right[i]-left[i]-1);   // b*(rightsmaller-leftsmaller-1 = l)
            max = Math.max(max, area[i]);
        }
        return max;
    }
    
    int[] leftSmaller(int arr[]) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int p = 0, pseudoIndex = -1, n = arr.length;

        for(int i=0; i<n; i++) {
            // if(stack.isEmpty()) {
            //     res[p++] = pseudoIndex;
            // } else if(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
            //     res[p++] = stack.peek();
            // } else if(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                while(stack.size()>0 && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) res[p++] = pseudoIndex;
                else res[p++] = stack.peek();
            // }
            stack.push(i);
        }
        return res;
    }
    
    int[] rightSmaller(int arr[]) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int p = 0, pseudoIndex = arr.length, n = arr.length;
        
        for(int i=n-1; i>=0; i--) {
            // if(stack.isEmpty()) {
            //     res[p++] = pseudoIndex;
            // } else if(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
            //     res[p++] = stack.peek();
            // } else if(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                while(stack.size()>0 && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) res[p++] = pseudoIndex;
                else res[p++] = stack.peek();
            // }
            stack.push(i);
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
    
    int[] findSmaller(int arr[], boolean right) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int p = 0, pseudoIndex, n = arr.length;
        
        if(right) { pseudoIndex = arr.length; }
        else { pseudoIndex = -1; }
        
        if(right) {
            for(int i=0; i<n; i++) {
                while(stack.size()>0 && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) res[p++] = pseudoIndex;
                else res[p++] = stack.peek();
            stack.push(i);
            }
        } else {
            for(int i=n-1; i>=0; i--) {
                while(stack.size()>0 && arr[stack.peek()] <= arr[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) res[p++] = pseudoIndex;
                else res[p++] = stack.peek();
            stack.push(i);
            }
        }
        
        // reverse
        if(right) {
            int i=0, j=n-1;
            while(i<=j) {
                int temp = res[i];
                res[i++] = res[j];
                res[j--] = temp;
            }
        }
        return res;
	} 
}