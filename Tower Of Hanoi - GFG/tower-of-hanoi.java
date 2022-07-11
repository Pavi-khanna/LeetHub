// { Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();//total testcases
        while (T-- > 0) {
            Hanoi obj = new Hanoi();
            int N;
            
            //taking input N
            N = sc.nextInt();

            //calling toh() method 
            System.out.println(obj.toh(N, 1, 3, 2));
        }
    }
}





// } Driver Code Ends


// User function Template for Java


// avoid space at the starting of the string in "move disk....."
class Hanoi {

    public long toh(int n, int from, int to, int aux) {
        // Your code here
        long[] moves = new long[1];
        moves[0] = 0L;
        toh(n, from, to, aux, moves);
        return moves[0];
    }
    
    public void toh(int n, int from, int to, int aux, long[] moves) {
        moves[0]++;
        
        if(n==1) {
            System.out.println("move disk "+ n + " from rod "+from+" to rod "+to);
            return;
        }
        toh(n-1, from, aux, to, moves);
        
        System.out.println("move disk "+ n + " from rod "+from+" to rod "+to);
        
        toh(n-1, aux, to, from, moves);
    }
}
