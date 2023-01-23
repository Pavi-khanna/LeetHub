//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // n^2, n^2
        int n=grid.length;
        int m= grid[0].length;
        int[][] vis = new int[n][m];
        int count=0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(vis[i][j]==0 && grid[i][j]=='1') {
                    count++;
                    bfs(i, j, vis, grid);
                }
            }
        }
        return count;
    }
    
    private void bfs(int r, int c, int[][] vis, char[][] grid) {
        vis[r][c]=1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));
        
        int n=grid.length;
        int m= grid[0].length;
        
        while(!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            
            // traverse all neighbours and mark if its land
            for(int dirX=-1; dirX<=1; dirX++) {
                for(int dirY=-1; dirY<=1; dirY++) {
                    int nrow = dirX+row;
                    int ncol = dirY+col;
                    
                    // valid, 1, not visited
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]=='1') {
                       vis[nrow][ncol]=1;
                       q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }
}
class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}