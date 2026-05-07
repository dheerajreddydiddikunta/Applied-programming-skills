class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int src=edges[i][0];
            int dest=edges[i][1];
            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }
        boolean[] vis=new boolean[n];
        helper(source,adj,vis);
        return vis[destination];
    }
    public void helper(int node,List<List<Integer>> adj,boolean[] vis){
        vis[node]=true;
        for(int i=0;i<adj.get(node).size();i++){
            int neigh=adj.get(node).get(i);
            if(!vis[neigh]){
                helper(neigh,adj,vis);
            }
        }
    }
}