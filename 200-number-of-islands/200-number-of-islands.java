class Solution {
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
            int[] dirX = {0, -1, 0, 1};
            int[] dirY = {-1, 0, 1, 0};
            for(int i=0; i<4; i++) {
                    int nrow = dirX[i]+row;
                    int ncol = dirY[i]+col;
                    
                    // valid, 1, not visited
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m 
                       && vis[nrow][ncol]==0 && grid[nrow][ncol]=='1') {
                       vis[nrow][ncol]=1;
                       q.add(new Pair(nrow, ncol));
                    }
            }
            
//             for(int dirX=-1; dirX<=1; dirX++) {
//                 for(int dirY=-1; dirY<=1; dirY++) {
                    
//                 }
//             }
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