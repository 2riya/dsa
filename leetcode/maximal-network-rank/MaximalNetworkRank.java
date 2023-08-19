public class MaximalNetworkRank {
    public static void main(String[] args) {
        int[][] roads = new int[][] {{0, 1}, {1, 2}, {2, 3}, {2, 4}, {5, 6}, {5, 7}};
        int n = 8;
        System.out.println(bruteForce(roads, n));
    }

    private static int bruteForce(int[][] roads, int n) {
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int roadCount = 0;
                for (int[] road : roads) {
                    if (road[0] == i || road[1] == j || road[0] == j || road[1] == i) {
                        roadCount++;
                    }
                }
                max = Math.max(max, roadCount);
            }
        }

        return max;
    }

    private static int graphMethod(int[][] roads, int n) {
        // TODO: Implement

        return 0;
    }
}
