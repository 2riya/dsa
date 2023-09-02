import java.util.Arrays;
import java.util.Comparator;

public class KruskalsAlgorithm {
    public static void main(String[] args) {
        int n = 6;
        int[][] weightedEdges = /* {vertex1, vertex2, weight} */
            new int[][] {{1, 4, 1}, {1, 2, 2}, {2, 3, 3}, {2, 4, 3}, {1, 5, 4}, {3, 4, 5},
                {2, 6, 7}, {3, 6, 8}, {4, 5, 9}};

        int minSpanningTree = kruskalsAlgorithm(weightedEdges, n);
        System.out.println(minSpanningTree);
    }

    private static int kruskalsAlgorithm(int[][] weightedEdges, int n) {
        Arrays.sort(weightedEdges, Comparator.comparingInt(o -> o[2]));

        UnionByRankWPathComp.DisjointSet ds = new UnionByRankWPathComp.DisjointSet(n + 1);

        int totalWeight = 0;
        for (int[] edge : weightedEdges) {
            int v1 = edge[0];
            int v2 = edge[1];
            int weight = edge[2];
            if (ds.find(v1) != ds.find(v2)) { /* include only those edges that aren't a part of connected component yet */
                ds.union(v1, v2);
                totalWeight += weight;
            }
        }

        return totalWeight;
    }
}
