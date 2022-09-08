class Solution {
    public int countComponents(int n, int[][] edges) {
        // n, 2n
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        
        for(int i=0; i<edges.length; i++) {
                adjList.get(edges[i][0]).add(edges[i][1]);
                adjList.get(edges[i][1]).add(edges[i][0]);
        }
        
        int[] vis = new int[n];
        int count=0;
        for(int i=0; i<n; i++) {
            if(vis[i]==0) {
                count++;
                dfs(i, vis, adjList);
            }
        }
        return count;
    }
    
    public static void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node]=1;

        for(Integer it : adj.get(node)) {
            if(vis[it]==0) {
                dfs(it, vis, adj);
            }
        }
    }
}