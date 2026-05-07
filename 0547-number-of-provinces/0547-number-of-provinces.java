class Solution {

    public void dfs(List<Integer>[] adjList, boolean[] visited, int curr) {
        visited[curr] = true;
        for (int neighbor : adjList[curr]) {
            if (!visited[neighbor]) {
                dfs(adjList, visited, neighbor);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        List<Integer>[] adjList = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }

         for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjList[i].add(j);
                    adjList[j].add(i); // Since it's undirected
                }
            }
        }

        boolean[] visited = new boolean[V];
        int provinces = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                provinces++;
                dfs(adjList, visited, i);
            }
        }

        return provinces;
    }
}