class Pair {
    int x, y, dist;
    Pair(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.dist - a.dist);
        for(int i = 0; i < points.length; i++) {
            pq.add(new Pair(points[i][0], points[i][1], points[i][0] * points[i][0] + points[i][1] * points[i][1]));
            if(pq.size() > k) pq.remove();
        }

        int[][] ans = new int[k][2];
        int j = 0;
        while(pq.size() > 0) {
            ans[j++] = new int[]{pq.peek().x, pq.peek().y};
            pq.poll();
        }

        return ans;
    }
}