class Solution {
    public int maximalRectangle(char[][] matrix) {
        // n^3*m^3, 1
        // create all rectangles
        // check whether there is a zero in that or not
        // if not, calculate its area
        // return the maximum area out of it
        
//         int n = matrix.length, m = matrix[0].length;
        
//         int maxArea = 0;
//         for(int i = 0; i < n; i++) {
//             for(int j = 0; j < m; j++) {
//                 // coordinates of the top left corner of the rectangle
//                 int startingX = i, startingY = j;
                
//                 for(int k = i; k < n; k++) {
//                     for(int l = j ; l < m; l++) {
//                         // coordinates of the bottom right corner of the rectangle
//                         int endingX = k, endingY = l;
//                         // check whether its contains only one
//                         if(isEligible(matrix, startingX, startingY, endingX, endingY)) {
//                             maxArea = Math.max(maxArea, (endingX - startingX + 1) * 
//                                                (endingY - startingY + 1));
//                         }
//                     }
//                 }
//             }
//         }
//         return maxArea;
        
        
        // n*m, m
        int[] height = new int[matrix[0].length];
        for(int j=0; j<matrix[0].length; j++) height[j] = matrix[0][j] == '0' ? 0 : 1;
        int max = largestRectangleArea(height);

        for(int i=1; i<matrix.length; i++) {
            int p=0;
            for(int j=0; j<matrix[0].length; j++) {
                //System.out.print(height[j]+" ");

                if(matrix[i][j] == '0') height[p++] = 0;
                else height[p] = matrix[i][j] == '0' ? 0 : height[p++]+1;
            }
            //System.out.println();
            max = Math.max(max, largestRectangleArea(height));
        }
        return max;
    }
    
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, max = Integer.MIN_VALUE;
        int[] left = leftSmaller(heights), right = rightSmaller(heights), area = new int[n];
        for(int i=0; i<heights.length; i++) {
            area[i] = heights[i] * (right[i]-left[i]-1);
            max = Math.max(max, area[i]);
        }
        return max;
    }
    
    int[] leftSmaller(int arr[]) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int p = 0, pseudoIndex = -1, n = arr.length;

        for(int i=0; i<n; i++) {
            if(stack.isEmpty()) {
                res[p++] = pseudoIndex;
            } else if(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                res[p++] = stack.peek();
            } else if(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                while(stack.size()>0 && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) res[p++] = pseudoIndex;
                else res[p++] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }
    
    int[] rightSmaller(int arr[]) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int p = 0, pseudoIndex = arr.length, n = arr.length;
        
        for(int i=n-1; i>=0; i--) {
            if(stack.isEmpty()) {
                res[p++] = pseudoIndex;
            } else if(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                res[p++] = stack.peek();
            } else if(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                while(stack.size()>0 && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()) res[p++] = pseudoIndex;
                else res[p++] = stack.peek();
            }
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
    
    
    public static boolean isEligible(char[][] arr, int startingX, int startingY, int endingX, int endingY){
        for(int i = startingX; i <= endingX; i++) {
            for(int j = startingY; j <= endingY; j++) {
                if(arr[i][j] == '0') {
                    return false;
                }
            }
        }
        
        return true;
    }
}