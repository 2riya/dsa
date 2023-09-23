import java.util.HashMap;
import java.util.HashSet;

public class DFTGraph {
    public static void main(String[] args) {
        int[][] edges =
            {{0, 1}, {0, 2}, {0, 3}, {1, 3}, {2, 4}, {3, 5}, {3, 6}, {4, 7}, {4, 5}, {5, 2}};
        System.out.println(dft(edges));
    }

    private static String dft(int[][] edges) {
        HashMap<Integer, HashSet<Integer>> adjacencyList = new HashMap<>();

        // undirected graph
        for (int[] edge : edges) {
            adjacencyList.putIfAbsent(edge[0], new HashSet<>());
            HashSet<Integer> nbrs = adjacencyList.get(edge[0]);
            nbrs.add(edge[1]);

            adjacencyList.putIfAbsent(edge[1], new HashSet<>());
            nbrs = adjacencyList.get(edge[1]);
            nbrs.add(edge[0]);
        }

        StringBuilder path = new StringBuilder();
        HashSet<Integer> visited = new HashSet<>();
        for (int vertex : adjacencyList.keySet()) {
            if (!visited.contains(vertex)) {
                path.append(dftHelper(vertex, visited, adjacencyList));
            }
        }

        return path.toString();
    }

    private static String dftHelper(int currNode, HashSet<Integer> visited, HashMap<Integer, HashSet<Integer>> adjacencyList) {
        StringBuilder result = new StringBuilder();
        visited.add(currNode);

        result.append(currNode);
        result.append(" ");

        for (int nbr : adjacencyList.get(currNode)) {
            if (!visited.contains(nbr)) {
                result.append(dftHelper(nbr, visited, adjacencyList));
            }
        }

        return result.toString();
    }
}

/**
 * V - No. of vertices
 * E - No. of edges
 *
 * Time Complexity : O(V+E)
 * -> V because all vertices will be traversed for sure,
 *  plus E because each edge is also traversed
 *
 * Space Complexity: O(V)
 * -> Recursion stack, visited set
 */
