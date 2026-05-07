class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if (sr < 0 || sc < 0 || sr >= image.length || sc > image[0].length) {
            return image;
        }
        int prev = image[sr][sc];
        if(prev == color) {
            return image; 
        }

        flood(image, sr, sc, prev, color);
        return image;
    }

    public void flood(int[][] image, int sr, int sc, int prev, int color) {

        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != prev) {
            return;
        }

        image[sr][sc] = color;

        flood(image, sr-1, sc, prev, color);
        flood(image, sr+1, sc, prev, color);
        flood(image, sr, sc-1, prev, color);
        flood(image, sr, sc+1, prev, color);
    }
}