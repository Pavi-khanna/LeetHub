class Solution {
    public int orangesRotting(int[][] grid) {
        // nm, nm
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        
        int[][] vis = new int[n][m];
        int countFresh=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]==2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }
                
                if(grid[i][j] == 1) countFresh++;
            }
        }
        
        int tm = 0, count = 0;
        int[] dirX = {0, -1, 0, 1};
        int[] dirY = {-1, 0, 1, 0};
        while(!q.isEmpty()) {
            int r = q.peek().first;
            int c = q.peek().second;
            int t = q.peek().time;
            tm = Math.max(tm, t);
            q.remove();
            
            for(int i=0; i<4; i++) {
            int nrow = r+dirX[i];
            int ncol = c+dirY[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m 
                    && grid[nrow][ncol]==1 && vis[nrow][ncol]!=2) {
                    q.add(new Pair(nrow, ncol, t+1));
                    vis[nrow][ncol] = 2;
                    count++;
                }
            }
        }
        
        if(countFresh != count) return -1;
        
        // for(int i=0; i<n; i++) {
        //     for(int j=0; j<m; j++) {
        //         if(vis[i][j]!=2 && grid[i][j]==1) {
        //             return -1;
        //         }
        //     }
        // }
            
        
        return tm;
    }
}

class Pair {
    int first;
    int second;
    int time;
    public Pair(int first, int second, int time) {
        this.first = first;
        this.second = second;
        this.time = time;
    }
}