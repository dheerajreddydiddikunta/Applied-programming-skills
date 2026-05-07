class Solution {
    public static int[][] updateMatrix(int[][] mat) {

        int rowLength = mat.length, columnLength = mat[0].length;

        int[][] visited = new int[rowLength][columnLength];
        Queue<int[]> queue = new LinkedList<>();

        // Add all zero cells to the queue
        for (int row = 0; row < rowLength; row++) {
            for (int column = 0; column < columnLength; column++) {
                if (mat[row][column] == 0) {
                    visited[row][column] = 1;
                    queue.add(new int[]{row, column});
                }
            }
        }

        int[][] directions = { {1,0}, {-1,0}, {0,1}, {0,-1} };

        // Multi-source BFS
        while (!queue.isEmpty()) {
            int[] index = queue.poll();
            int row = index[0];
            int column = index[1];

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newColumn = column + direction[1];

                if (newRow >= 0 && newRow < rowLength &&
                    newColumn >= 0 && newColumn < columnLength &&
                    visited[newRow][newColumn] == 0) {

                    visited[newRow][newColumn] = 1;
                    mat[newRow][newColumn] = mat[row][column] + 1;
                    queue.add(new int[]{newRow, newColumn});
                }
            }
        }
        return mat;
    }
}