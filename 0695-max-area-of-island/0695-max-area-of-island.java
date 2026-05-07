class Solution {

    int n, m;
    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int maxArea = 0;

        for(int i = 0; i < n ; i++){
            for(int j = 0 ; j<m; j++){

                if(grid[i][j] == 1 && !visited[i][j]){
                    int area = dfsGrid(i,j,grid,visited);
                    maxArea  = Math.max(area,maxArea);
                }
            }
        }
        return maxArea;
    }

    private int dfsGrid(int r, int c, int[][] grid ,  boolean[][] visited ){

        if(r < 0 || c < 0 || r>=n || c>=m) return 0 ;
        if(visited[r][c] || grid[r][c] == 0) return 0;

        visited[r][c] = true;

        int area = 1;

        area += dfsGrid(r+1,c,grid,visited);
        area +=dfsGrid(r-1,c,grid,visited);
        area +=dfsGrid(r,c+1,grid,visited);
        area +=dfsGrid(r,c-1,grid,visited);

        return area;
    
    }
}