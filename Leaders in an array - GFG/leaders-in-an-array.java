// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Array {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		
		while(t-->0){
		    
		    //input size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //inserting elements in the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    StringBuffer str = new StringBuffer();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		  
		    //calling leaders() function
		    res = obj.leaders(arr, n);
		    
		    //appending result to a String
		    for(int i=0; i<res.size(); i++){
		        str.append(res.get(i)+" ");
		    }
		    
		    //printing the String
		    System.out.println(str);
		}
		
	}
}
// } Driver Code Ends


class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        
        // n^2, 1
        // ArrayList<Integer> res = new ArrayList<>();
        // for(int i=0; i<n; i++) {
        //     boolean flag = true;
        //     for(int j=i+1; j<n; j++) {
        //         if(arr[i] < arr[j]) {
        //             flag = false;
        //         }
        //     }
        //     if(flag) res.add(arr[i]);
        // }
        // return res;
        
        
        // n, n (o/p in order)
        // Stack<Integer> stack = new Stack<>();
        // ArrayList<Integer> res = new ArrayList<>();
        // stack.push(arr[n-1]);
        // for(int i=n-2; i>=0; i--) {
        //     if(stack.peek() <= arr[i]) stack.push(arr[i]);
        // }
        // while(!stack.isEmpty()) {
        //     res.add(stack.pop());
        // }
        // return res;
        
        
        // n, 1
        ArrayList<Integer> res = new ArrayList<>();
        int rightMax = arr[n-1];
        res.add(rightMax);
        for(int i=n-2; i>=0; i--) {
            if(arr[i] >= rightMax) res.add(arr[i]);
            rightMax = Math.max(rightMax, arr[i]);
        }
        // Collections.reverse(res);
        reverseList(res);
        return res;
    }
    
    public static void reverseList(ArrayList<Integer> list) {
        int n = list.size();
        
        for(int i=0; i<list.size()/2; i++) {
            int temp = list.get(i);
            list.set(i, list.get(n-i-1));
            list.set(n-i-1, temp);
        }
    }
}
