import java.util.Queue;

public class RottingOranges {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        // example where fresh oranges will always remain, result = -1
        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int result = orangesRotting(grid);
        System.out.println(result);

        // example where all oranges will rot eventually
        grid = new int[][] {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        result = orangesRotting(grid);
        System.out.println(result);
    }

    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // [row, col]
        Queue<int[]> bfs = new java.util.LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    bfs.add(new int[] {i, j});
                }
            }
        }

        int mins = 0;

        while (!bfs.isEmpty()) {
            for (int i = bfs.size(); i > 0; i--) {
                int[] curr = bfs.poll();

                for (int[] dir : DIRS) {
                    int cr = curr[0] + dir[0];
                    int cc = curr[1] + dir[1];

                    if (cr >= 0 && cr < m && cc >= 0 && cc < n && grid[cr][cc] == 1) {
                        grid[cr][cc] = 2;
                        bfs.add(new int[] {cr, cc});
                    }
                }
            }

            // all oranges rotten in current iteration will be present in bfs queue
            if (!bfs.isEmpty()) {
                mins++;
            }
        }


        // if any orange is left fresh, return -1
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        } // PS: This traversal can be reduced by counting no. of fresh oranges in the beginning itself and count the no. of oranges getting rotten during BFS

        return mins;
    }
}
