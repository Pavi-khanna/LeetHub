// { Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    public int maxArea(int matrix[][], int n, int m) {
        int[] height = new int[matrix[0].length];
        for(int j=0; j<matrix[0].length; j++) height[j] = matrix[0][j];
        int max = largestRectangleArea(height);

        for(int i=1; i<matrix.length; i++) {
            int p=0;
            for(int j=0; j<matrix[0].length; j++) {
                //System.out.print(height[j]+" ");

                if(matrix[i][j] == 0) height[p++] = 0;
                else height[p++] += matrix[i][j];
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
}