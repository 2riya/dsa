import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        int[][] input = new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        mergeOverlappingIntervals(input);
    }

    private static int[][] mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        ArrayList<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int resultLastIdx = result.size() - 1;

            int a = result.get(resultLastIdx)[0];
            int b = result.get(resultLastIdx)[1];

            int c = intervals[i][0];
            int d = intervals[i][1];

            if (b >= c) {
                result.remove(resultLastIdx);
                result.add(new int[] {a, Math.max(b, d)});
            } else {
                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
