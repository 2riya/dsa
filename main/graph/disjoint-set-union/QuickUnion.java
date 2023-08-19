import java.util.Arrays;

public class QuickUnion {
    public static void main(String[] args) {
        int[][] edges = new int[][] {{1, 2}, {2, 3}, {4, 5}, {6, 7}, {5, 6}, {3, 7}};
        int n = 7;
        quickUnion(edges, n);
    }

    private static void quickUnion(int[][] edges, int n) {
        DisjointSet ds = new DisjointSet(n + 1);

        // before union, 3 and 7 belongs to diff components
        System.out.println(ds.find(3) == ds.find(7)); // o/p: false

        for (int[] edge : edges) {
            ds.union(edge[0], edge[1]);
            System.out.println(
                String.format("Union of %s and %s : ", edge[0], edge[1]) +
                    Arrays.stream(ds.parent)
                        .boxed()
                        .toList());
        }

        // after union, 3 and 7 belongs to same components
        System.out.println(ds.find(3) == ds.find(7)); // o/p: true
    }

    static class DisjointSet {
        private final int[] parent;

        public DisjointSet(int n) {
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int v1, int v2) {
            int rV1 = find(v1);
            int rV2 = find(v2);

            if (rV1 == rV2) {
                return;
            }

            parent[v2] = rV1;
        }

        public int find(int v) {
            return findRoot(v);
        }

        private int findRoot(int v) {
            if (v == parent[v]) {
                return v;
            }
            return findRoot(parent[v]);
        }
    }
}
