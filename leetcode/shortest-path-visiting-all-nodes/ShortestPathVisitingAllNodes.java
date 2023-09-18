import java.util.Queue;

public class ShortestPathVisitingAllNodes {
    public static void main(String[] args) {
        int[][] graph = {{1,2,3},{0},{0},{0}};
        System.out.println(shortestPathLength(graphg));
    }

    public static int shortestPathLength(int[][] graph) {
        int n = graph.length;

        int allNodes = (1 << n) - 1;

        int minPath = Integer.MAX_VALUE;

        for (int i = 0; i < graph.length; i++) {
            boolean[][] visited = new boolean[n][allNodes + 1];

            Queue<int[]> q = new java.util.LinkedList<>();
            q.add(new int[]{i, (1 << i), 0});

            while (!q.isEmpty()) {
                int[] polled = q.poll();

                int node = polled[0];
                int mask = polled[1];
                int dist = polled[2];

                if (visited[node][mask]) {
                    continue;
                }

                if (mask == allNodes) {
                    minPath = Math.min(minPath, dist);
                }

                visited[node][mask] = true;

                for (int j = 0; j < graph[node].length; j++) {
                    int nbr = graph[node][j];

                    int currMask = mask | (1 << nbr);
                    int currDist = dist + 1;

                    q.add(new int[]{nbr, currMask, currDist});
                }
            }
        }

        return minPath;
    }
}
