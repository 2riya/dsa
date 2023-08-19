import java.util.Arrays;

public class QuickFind {
    public static void main(String[] args) {
        int[][] edges = new int[][] {{1, 2}, {2, 3}, {4, 5}, {6, 7}, {5, 6}, {3, 7}};
        int n = 7;
        quickFind(edges, n);
    }

    private static void quickFind(int[][] edges, int n) {
        DisjointSet ds = new DisjointSet(n + 1);
        for (int[] edge : edges) {
            ds.union(edge[0], edge[1]);
            System.out.println(
                String.format("Union of %s and %s : ", edge[0], edge[1]) +
                    Arrays.stream(ds.parent)
                    .boxed()
                    .toList());
        }
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
            int pV1 = parent[v1];
            int pV2 = parent[v2];

            if (pV1 == pV2) {
                return;
            }

            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == pV2) {
                    parent[i] = pV1;
                }
            }
        }

        public int find(int v) {
            return parent[v];
        }
    }
}
