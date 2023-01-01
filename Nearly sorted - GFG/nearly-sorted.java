//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int num = sc.nextInt();
            int k = sc.nextInt();
            
            int arr[] = new int[num];
            for(int i = 0; i < num; i++)
                arr[i] = sc.nextInt();
            
            ArrayList <Integer> res = new Solution().nearlySorted(arr, num, k);
            for (int i = 0; i < res.size (); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


class Solution
{
    //Function to return the sorted array.
    ArrayList <Integer> nearlySorted(int arr[], int n, int k)
    {
        // Arrays.sort(arr);
        // ArrayList<Integer> ans = new ArrayList<>();
        // for(int ele : arr) ans.add(ele);
        // return ans;
        
        
        
        // for(int i=1; i<n; i++) {
        //     int key = nums[i];
        //     int j=i-1;
            
        //     while(j>=0 && nums[j]>key) {
        //         nums[j+1] = nums[j];
        //         j--;
        //     }
        //     nums[j+1] = key;
        // }
        // ArrayList<Integer> intList = new ArrayList<Integer>(nums.length);
        // for (int i : nums) {
        //     intList.add(i);
        // }
        // return intList;
        
        
        
        if (arr == null || arr.length == 0) { return null; }
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        
        for (int i = 0; i < Math.min(arr.length, k + 1); i++) {
            priorityQueue.add(arr[i]);
        }
 
        int index = 0;
        int[] ans = new int[n];
        for (int i = k + 1; i < n; i++) {
            ans[index++] = priorityQueue.poll();
            priorityQueue.add(arr[i]);
        }
 
        Iterator<Integer> itr = priorityQueue.iterator();
 
        while (itr.hasNext()) {
            ans[index++] = priorityQueue.peek();
            priorityQueue.poll();
        }
        ArrayList<Integer> intList = new ArrayList<Integer>();
        for (int i : ans) {
            intList.add(i);
        }
        return intList;
    }
}
