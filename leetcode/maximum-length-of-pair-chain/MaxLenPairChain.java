import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;

public class MaxLenPairChain {
    public static void main(String[] args) {

    }

    private int monotonicStack(int[][] pairs) {
        Arrays.sort(pairs, (o1, o2) -> o1[0] - o2[0]);

        int b = pairs[0][1];

        ArrayDeque<int[]> stack = new ArrayDeque<>();
        stack.add(pairs[0]);

        for (int j = 1; j < pairs.length; j++) {
            int c = pairs[j][0];
            int d = pairs[j][1];

            if (b > d) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                stack.addFirst(pairs[j]);
            }

            b = stack.peek()[1];

            if (b < c) {
                stack.addFirst(pairs[j]);
                b = stack.peek()[1];
            }
        }

        return stack.size();
    }

    private int greedy(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        int curr = Integer.MIN_VALUE;
        int ans = 0;

        for (int[] pair : pairs) {
            if (pair[0] > curr) {
                ans++;
                curr = pair[1];
            }
        }
        return ans;
    }
}
