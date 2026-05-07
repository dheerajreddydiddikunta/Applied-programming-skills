import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
            List<Integer>[] red = new ArrayList[n];
                    List<Integer>[] blue = new ArrayList[n];

                            for (int i = 0; i < n; i++) {
                                        red[i] = new ArrayList<>();
                                                    blue[i] = new ArrayList<>();
                                                            }

                                                                    for (int[] e : redEdges) red[e[0]].add(e[1]);
                                                                            for (int[] e : blueEdges) blue[e[0]].add(e[1]);

                                                                                    int[] res = new int[n];
                                                                                            Arrays.fill(res, -1);

                                                                                                    Queue<int[]> q = new LinkedList<>();
                                                                                                            boolean[][] visited = new boolean[n][2];

                                                                                                                    q.add(new int[]{0, 0});
                                                                                                                            q.add(new int[]{0, 1});
                                                                                                                                    visited[0][0] = visited[0][1] = true;

                                                                                                                                            int dist = 0;

                                                                                                                                                    while (!q.isEmpty()) {
                                                                                                                                                                int size = q.size();
                                                                                                                                                                            for (int i = 0; i < size; i++) {
                                                                                                                                                                                            int[] curr = q.poll();
                                                                                                                                                                                                            int node = curr[0], color = curr[1];

                                                                                                                                                                                                                            if (res[node] == -1) res[node] = dist;

                                                                                                                                                                                                                                            List<Integer>[] graph = color == 0 ? blue : red;

                                                                                                                                                                                                                                                            for (int next : graph[node]) {
                                                                                                                                                                                                                                                                                if (!visited[next][1 - color]) {
                                                                                                                                                                                                                                                                                                        visited[next][1 - color] = true;
                                                                                                                                                                                                                                                                                                                                q.add(new int[]{next, 1 - color});
                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                            dist++;
                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                            return res;
                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                }