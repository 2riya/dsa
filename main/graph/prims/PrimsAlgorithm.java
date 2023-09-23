import java.util.*;

public class PrimsAlgorithm {
    public static void main(String[] args) {
        // [u, v, w]
        int[][] edges =
            {{0, 1, 3}, {1, 3, 3}, {1, 5, 10}, {2, 4, 6}, {2, 6, 9}, {3, 6, 8}, {4, 5, 6}};

        System.out.println(primsAlgorithm(edges));
    }

    private static int primsAlgorithm(int[][] edges) {
        HashMap<Integer, List<int[]>> adjacencyMatrix = new HashMap<>();

        for (int[] edge : edges) {
            adjacencyMatrix.putIfAbsent(edge[0], new ArrayList<>());
            adjacencyMatrix.get(edge[0]).add(new int[] {edge[1], edge[2]});

            adjacencyMatrix.putIfAbsent(edge[1], new ArrayList<>());
            adjacencyMatrix.get(edge[1]).add(new int[] {edge[0], edge[2]});
        }

        // [u, v, w]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        minHeap.add(new int[] {0, 0, 0});

        boolean[] visited = new boolean[adjacencyMatrix.size()];
        int totalWeight = 0;

        while (!minHeap.isEmpty()) {
            int[] polled = minHeap.poll();
            int nbr = polled[1];
            int weight = polled[2];

            if (visited[nbr]) {
                continue;
            }

            totalWeight += weight;
            visited[nbr] = true;

            for (int[] edge : adjacencyMatrix.get(nbr)) {
                minHeap.add(new int[] {nbr, edge[0], edge[1]});
            }
        }

        return totalWeight;
    }
}
