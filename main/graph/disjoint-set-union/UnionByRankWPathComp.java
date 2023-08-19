import java.util.Arrays;

public class UnionByRankWPathComp {
    public static void main(String[] args) {
        int[][] edges = new int[][] {{1, 2}, {2, 3}, {4, 5}, {6, 7}, {5, 6}, {3, 7}};
        int n = 7;
        unionByRankWPathComp(edges, n);
    }

    private static void unionByRankWPathComp(int[][] edges, int n) {
        DisjointSet ds = new DisjointSet(n + 1);

        // before union, 3 and 7 belongs to diff components
        System.out.println(ds.find(3) == ds.find(7)); // o/p: false

        for (int[] edge : edges) {
            ds.union(edge[0], edge[1]);
            System.out.println(
                String.format("Union of %s and %s : ", edge[0], edge[1])
                    + Arrays.stream(ds.parent)
                    .boxed()
                    .toList()
                    + " Rank: "
                    + Arrays.stream(ds.rank)
                    .boxed()
                    .toList());
        }

        // after union, 3 and 7 belongs to same components
        System.out.println(ds.find(3) == ds.find(7)); // o/p: true
    }

    static class DisjointSet {
        private final int[] rank;
        private final int[] parent;

        public DisjointSet(int n) {
            rank =
                new int[n]; // rank will store height, but further down the algorithm, height(v) might not be equal to rank(v), therefore calling it rank and not height itself
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int v1, int v2) {
            int rootOfV1 = find(v1);
            int rootOfV2 = find(v2);

            if (rootOfV1 == rootOfV2) {
                return;
            }

            if (rank[rootOfV1] >= rank[rootOfV2]) {
                parent[v2] = rootOfV1;
                rank[rootOfV1] = Math.max(rank[rootOfV1], rank[rootOfV2] + 1);
            } else {
                parent[v1] = rootOfV2;
                rank[rootOfV2]++;
            }
        }

        public int find(int v) {
            return findRoot(v);
        }

        private int findRoot(int v) {
            if (v == parent[v]) {
                return v;
            }
            parent[v] = findRoot(parent[v]);
            return parent[v];
        }
    }
}
