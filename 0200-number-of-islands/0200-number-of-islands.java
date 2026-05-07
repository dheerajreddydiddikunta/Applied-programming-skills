class Solution {

    public static boolean isSafe(char m[][],int i,int j, boolean visited[][]){
        return i>=0 && i<m.length && j>=0 && j<m[0].length && !visited[i][j] && m[i][j]=='1';
    }

    public static void DFS(char m[][],int i,int j,boolean visited[][]){
        visited[i][j]=true;

        int rno[] = {-1,0,0,1};
        int colno[] = {0,-1,1,0};

        for(int k=0;k<4;k++){
            if(isSafe(m,i+rno[k],j+colno[k],visited)){
                DFS(m,i+rno[k],j+colno[k],visited);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count=0;
        boolean visited[][] = new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    DFS(grid,i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }
}