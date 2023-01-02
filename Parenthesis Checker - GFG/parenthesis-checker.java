//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends




class Solution
{
    static Map<Character, Character> map = Map.of('(',')','{','}','[',']');

    //Function to check if brackets are balanced or not.
    static boolean ispar(String s)
    {
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            char it = s.charAt(i);
            
            if(map.containsKey(it)) st.push(it);
            else {
                if(st.isEmpty()) return false;
                char top = st.peek();
                if(it == map.get(top)) {
                    st.pop();
                    continue;
                } else return false;
            }
        }
        return st.isEmpty();
    }
}
