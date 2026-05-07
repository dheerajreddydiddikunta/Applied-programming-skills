class Solution {
    //0 --> empty cell
    //1 --> fresh orange
    //2 --> rotting orange
    class Pair {
        int x;
        int y;
        int time;
        Pair(int _x, int _y, int _time){
            x = _x;
            y = _y;
            time = _time;
        }
    }
    public boolean isValid(int i, int j, int n, int m){
        return i >= 0 && i < n && j >= 0 && j < m;
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        
        int n = grid.length;
        int m = grid[0].length;
        int cntFresh = 0;
        
        boolean [][]vis = new boolean [n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j] && grid[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                }
                else if(grid[i][j] == 1){
                    cntFresh++;
                }
            }
        }   

        int ans = 0;
        int cnt = 0;

        int [][]direc = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()){
            Pair current = q.poll();
            int x = current.x;
            int y = current.y;
            int time = current.time;

            ans = Math.max(time, ans);

            for(int []d : direc){
                int row = x + d[0];
                int col = y + d[1];

                if(isValid(row, col, n, m) && grid[row][col] == 1 && !vis[row][col]){
                    q.add(new Pair(row, col, time + 1));
                    vis[row][col] = true;
                    cnt++;
                }
            }
        }
        return cntFresh != cnt ? -1 : ans;
    }
}