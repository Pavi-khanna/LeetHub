//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        PrintWriter out=new PrintWriter(System.out);
        
        //taking testcases
        int t = Integer.parseInt(br.readLine()); 
    	for(int i=0;i<t;i++)
    	{
            String str=br.readLine();
    		
    		//input n and d
    	    int n=Integer.parseInt(str);
    		Stack<Integer> stack=new Stack<>();
    		String str1=br.readLine();
    		String[] starr1=str1.split(" ");
    		//inserting elements in the array
    		for(int j=0;j<n;j++)
    		{
    		    stack.push(Integer.parseInt(starr1[j]));
    		}
    		//calling reverse() function
            Solution.reverse(stack);
            for(int j:stack){
                out.print(j+" ");
            }
            out.println();
         }
         out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{ 
    static ArrayList<Integer> reverse(Stack<Integer> s) {
        if(s.size()==0) {
            return new ArrayList<>(s);
        }
        solve(s);
        ArrayList<Integer> l = new ArrayList<>(s);
        return l;
    }
    
    static public void solve(Stack<Integer> s) {
        if(s.size()==1) {
            return;
        }
        int temp = s.pop();
        solve(s);
        insert(s,temp);
    }
    
    static public void insert(Stack<Integer> s, int ele) {
        if(s.size()==0) {
            s.push(ele);
            return;
        }
        
        int temp = s.pop();
        insert(s, ele);
        s.push(temp);
    }
}